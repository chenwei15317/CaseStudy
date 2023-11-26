class Unit{

    int cost;
    Unit(){cost = 0;}
    public int getcost(){return cost;}
}

class LCD extends Unit{

    LCD(int i){
        if(i == 10)
            cost = 2000;

        if(i == 15)
            cost = 2500;

        if(i == 17)
            cost = 3000;
    }
}



class CPU extends Unit{
    CPU(double d){

        if(d == 1.66)
            cost = 6000;

        if(d == 2.2)
            cost = 8000;

        if(d == 2.4)
            cost = 11000;
    }
}



class HD extends Unit{
    HD(String s){
        if(s == "120G")
            cost = 2400;
        else
            cost = 2800;
    }
}



abstract class Note {

    double cost;
    LCD l;
    CPU c;
    HD dd;

    Note(int i, double d, String s){

        l = new LCD(i);
        c = new CPU(d);
        dd = new HD(s);
    }

    abstract public double getCost();
    abstract public double getPrice();
}

class MiniNote extends Note{
    MiniNote(){

        super(10, 1.66, "120G");
        cost = l.getcost() + c.getcost() + dd.getcost();

    }
    public double getCost(){return cost * 1.4;}
    public double getPrice(){return cost * 2.0;}
}

class Note15 extends Note{
    Note15(){
        super(15, 2.2, "160G");

        cost = l.getcost() + c.getcost() + dd.getcost();

    }
    public double getCost(){return cost * 1.4;}
    public double getPrice(){return cost * 2.0;}
}

abstract class PCandMultiPC {

    double cost;
    CPU l;
    HD c;

    PCandMultiPC(){

        l = new CPU(2.4);
        c = new HD("160G");

    }
    abstract public double getCost();
    abstract public double getPrice();
}

class PC extends PCandMultiPC{
    public double getCost(){

        return (l.getcost() + c.getcost() + 500);

    }
    public double getPrice(){

        return (l.getcost() + c.getcost() * 1.8);

    }
}

class MultiPC extends PCandMultiPC{
    double total;
    MultiPC(int a, int b){

        total = a * l.getcost() + b * c.getcost();
    }
    public double getCost(){return (total * 1.2);}
    public double getPrice(){return (total * 1.8);}
}

class AllPC{
    double a1, a2;
    AllPC(PCandMultiPC p, Note n){

        a1 = p.getCost();
        a2 = n.getCost();

    }
    public boolean isExpensive(){
        if (a1 > a2)
            return true;

        else
            return false;
    }
}

public class JPA06_3 {
    public static void main(String args[]){
        PC pc = new PC();
        Note15 note15 = new Note15();

        
        AllPC app = new AllPC(pc, note15);
        if(app.isExpensive())
            System.out.println("PC is more expensive than Note15");
        else
            System.out.println("Note15 is more expensive than PC");
    }
}