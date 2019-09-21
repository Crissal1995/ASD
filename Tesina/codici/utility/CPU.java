package utility;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

// Classe utilizzata per ottenere correttamente il tempo 
// impiegato per eseguire gli algoritmi
public class CPU {

    /** Get CPU time in nanoseconds. */
    public static long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
            bean.getCurrentThreadCpuTime() : 0L;
    }

    /** Get user time in milliseconds. */
    public static long getUserTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
            bean.getCurrentThreadUserTime() : 0L;
    }

    /** Get system time in milliseconds. */
    public static long getSystemTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
            (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime()) : 0L;
    }

}

