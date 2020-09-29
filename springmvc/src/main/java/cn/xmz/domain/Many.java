package cn.xmz.domain;

import java.util.List;
import java.util.Map;

public class Many {

    private String id;
    private List<User> list;
    private Map<String, User> map;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Many{" +
                "id='" + id + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
