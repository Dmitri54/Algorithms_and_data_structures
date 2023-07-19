package lectures.sem_01;

class Car { 
    
    public String name; 
    int seats;

    public Engine engine; 

    public Car() { 
        name = ""; 
        seats = 5;
        engine = new Engine();
    }

    public Car (String _name, int _seats){
        name = _name;
        seats = _seats;
        engine = new Engine();
    }

    public void print(){

        System.out.println(name);
        System.out.println("seats: " + seats);
        engine.print();
    }

    public static class Engine{ // Класс Двигателя, прописан внутри класса Car
        double tank;
        int V;
        int force;
        boolean wasForcing;

        void forcingEngine(){
            if (wasForcing)
                return;
            wasForcing = true;
            force *= 1.2;
        }

        void print () {
            System.out.print("Engine: ");
            System.out.print("V: " + V);
            System.out.print(", : " + tank + "L, ");
            System.out.print(force + "hp");
            if (wasForcing)
                System.out.print(" engine was forced");
            else
                System.out.print(" engine not forced");
            System.out.println();
        }
    }

}
