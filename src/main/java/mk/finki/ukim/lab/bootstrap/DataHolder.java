package mk.finki.ukim.lab.bootstrap;

import mk.finki.ukim.lab.model.Balloon;
import mk.finki.ukim.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons=new ArrayList<>();
    public static List<Manufacturer> manufacturers=new ArrayList<>();
    @PostConstruct
    public void init(){


        Manufacturer manufacturer1 = new Manufacturer("Test", "USA1","NY1");
        Manufacturer manufacturer2 = new Manufacturer("Test1", "USA2","NY2");
        Manufacturer manufacturer3 = new Manufacturer("Test2", "USA3","NY3");
        Manufacturer manufacturer4 = new Manufacturer("Test3", "USA4","NY4");
        Manufacturer manufacturer5 = new Manufacturer("Test4", "USA5","NY5");
        manufacturers.add(manufacturer1);
        manufacturers.add(manufacturer2);
        manufacturers.add(manufacturer3);
        manufacturers.add(manufacturer4);
        manufacturers.add(manufacturer5);

        this.balloons.add(new Balloon("1", "1",manufacturer1));
        this.balloons.add(new Balloon("2", "2",manufacturer1));
        this.balloons.add(new Balloon("3", "3",manufacturer2));
        this.balloons.add(new Balloon("4", "4",manufacturer2));
        this.balloons.add(new Balloon("5", "5",manufacturer3));
        this.balloons.add(new Balloon("6", "6",manufacturer3));
        this.balloons.add(new Balloon("7", "7",manufacturer4));
        this.balloons.add(new Balloon("8", "8",manufacturer4));
        this.balloons.add(new Balloon("9", "9",manufacturer5));
        this.balloons.add(new Balloon("10", "10",manufacturer5));

    }
}
