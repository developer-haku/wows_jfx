package dev.haku.wows.model;

public class Record {
    private final String type;
    private final int recordNum;
    private final String recordShip;

    public Record(String type, int recordNum, String recordShip) {
        this.type = type;
        this.recordNum = recordNum;
        this.recordShip = recordShip;
    }

    public String getType() {
        return type;
    }

    public int getRecordNum() {
        return recordNum;
    }

    public String getRecordShip() {
        return recordShip;
    }
}
