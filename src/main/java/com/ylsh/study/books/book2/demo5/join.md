## join实现
```$xslt
需要执行多少秒
public final synchronized void join(long millis)
    throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;


        if (millis == 0) {//如果传入为0 。判断线程是否活着。等待0 wait 由执行状态到可执行状态
            while (isAlive()) {
                wait(0);
            }
        } else {
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                wait(delay);
                now = System.currentTimeMillis() - base; //当前时间- base 如果间隔已经大于 millis。 则delay = millis - now 小于等于0。关键在此
            }
        }
    }

```
  