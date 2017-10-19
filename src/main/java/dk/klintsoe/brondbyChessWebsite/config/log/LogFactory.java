package dk.klintsoe.brondbyChessWebsite.config.log;

public class LogFactory {

    public static TimerLog getTimerLog() {
        return new TimerLog();
    }
}
