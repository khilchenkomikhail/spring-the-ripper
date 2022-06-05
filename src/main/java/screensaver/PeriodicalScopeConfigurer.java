package screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Duration;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigurer implements Scope {

    Map<String, Map.Entry<LocalTime, Object>> map = new HashMap<>();
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s)) {
            Map.Entry<LocalTime, Object> entry = map.get(s);
            int secondsSinceLastRequest = LocalTime.now().getSecond() - entry.getKey().getSecond();
            if (secondsSinceLastRequest > 3) {
                map.put(s, new AbstractMap.SimpleEntry<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(s, new AbstractMap.SimpleEntry<>(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
