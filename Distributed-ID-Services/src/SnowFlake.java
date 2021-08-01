import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SnowFlake {

    /*
    每部分占用位数
     */
    private final static long SEQUENCE_BIT = 12; //序号
    private final static long MACHINE_BIT = 5; //机器标识
    private final static long DATA_CENTER_BIT = 5;//数据中心
    /*
    每部分的最大值
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_DATA_CENTER_BIT = -1L ^ (-1L << DATA_CENTER_BIT);

    /*
    ID的构造 = 符号位(1 + 时间戳(41 + 机器ID(5 + 数据中心ID(5 + 序列号(12
    时间戳+机器+序列号???
    每部分想左边的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_LEFT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;
    /**
     * 项目开始时间作为时间戳开始时间
     */
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final long START_TIMESTAMP = format.parse("2021-08-01 10:56:50").getTime();

    private long dataCenterID;//数据中心ID
    private long machineID;//机器标识
    private long sequence = 0L;//序列号
    private long lastTimeStamp = -1L;//上一次时间戳

    /**
     * 根据指定数据中心ID和机器标识ID生成指定序列号
     *
     * @param dataCenterID
     * @param machineID
     * @throws ParseException
     */
    public SnowFlake(long dataCenterID, long machineID) throws ParseException {
        if (dataCenterID > MAX_MACHINE_NUM || dataCenterID < 0) {
            throw new IllegalArgumentException("数据中心ID不能大于最大值 或 不能小于0");
        }
        if (machineID > MAX_MACHINE_NUM || machineID < 0) {
            throw new IllegalArgumentException("机器号不能大于最大值,也不能小于0");
        }
        this.dataCenterID = dataCenterID;
        this.machineID = machineID;
    }

    public static void main(String[] args) throws ParseException {

        SnowFlake snowFlake = new SnowFlake(1, 2);
        for (int i = 0; i < (1 << 4); i++) {
            System.out.println(snowFlake.getID());
        }
    }

    private long getNextMill() {
        long mill = getNewTimeStamp();
        while (mill <= lastTimeStamp) {
            mill = getNewTimeStamp();
        }
        return mill;
    }

    /**
     * 获得当前时间戳
     *
     * @return 当前时间戳
     */
    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }

    public synchronized long getID() {
        long currTimeStamp = getNewTimeStamp();
        if (currTimeStamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards . Refused to generate id");
        }
        // 同毫秒内
        if (currTimeStamp == lastTimeStamp) {
            // 相同毫秒内,序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 同毫秒内,序列数达到最大
            if (sequence == 0L) {
                currTimeStamp = getNextMill();
            }
        } else {
            sequence = 0L;
        }
        lastTimeStamp = currTimeStamp;

        return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT
                | dataCenterID << DATA_CENTER_LEFT
                | machineID << MACHINE_LEFT
                | sequence;
    }
}
