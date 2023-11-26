class LCD {
    
    int size;
    int cost;


    public LCD(int size) {
        this.size = size;
        if (size == 10) {
            this.cost = 2000;
        } else if (size == 15) {
            this.cost = 2500;
        } else if (size == 17) {
            this.cost = 3000;
        }
    }
}


class CPU {
    double speed;
    int cost;

    public CPU(double speed) {
        this.speed = speed;
        if (speed == 1.66) {
            this.cost = 6000;
        } else if (speed == 2.2) {
            this.cost = 8000;
        } else if (speed == 2.4) {
            this.cost = 11000;
        }
    }
}


class HD {
    int capacity;
    int cost;

    public HD(int capacity) {
        this.capacity = capacity;
        if (capacity == 120) {
            this.cost = 2400;
        } else if (capacity == 160) {
            this.cost = 2800;
        }
    }
}


class MiniNote {
    LCD lcd;
    CPU cpu;
    HD hd;

    public MiniNote() {
        this.lcd = new LCD(10);
        this.cpu = new CPU(1.66);
        this.hd = new HD(120);
    }

    public int getCost() {
        return (int) (1.4 * (lcd.cost + cpu.cost + hd.cost));
    }

    public int getPrice() {
        return 2 * (lcd.cost + cpu.cost + hd.cost);
    }
}


class Note15 {
    LCD lcd;
    CPU cpu;
    HD hd;

    public Note15() {
        this.lcd = new LCD(15);
        this.cpu = new CPU(2.2);
        this.hd = new HD(160);
    }

    public int getCost() {
        return (int) (1.4 * (lcd.cost + cpu.cost + hd.cost));
    }

    public int getPrice() {
        return 2 * (lcd.cost + cpu.cost + hd.cost);
    }
}










public class JPA06_1 {
    public static void main(String[] args) {
        MiniNote miniNote = new MiniNote();
        Note15 note15 = new Note15();

        System.out.println("MiniNote cost: " + miniNote.getCost() + ", price: " + miniNote.getPrice());
        System.out.println("Note15 cost: " + note15.getCost() + ", price: " + note15.getPrice());
    }
}
