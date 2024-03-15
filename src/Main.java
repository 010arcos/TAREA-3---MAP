import java.util.*;

public class Main {
    public  ArrayList<Ubicacion> listaUbicaciones= new ArrayList<>();

    public Main(){
        Ubicacion claseProgramacion= new Ubicacion(0, "Estás sentado en la clase de programación, ¡hasta pronto!");
        Ubicacion mountain = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion playa = new Ubicacion(2, "Estás bañandote en la playa");
        Ubicacion edificio = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion puente =  new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion bosque = new Ubicacion(5, "Estás en un bosque");
        listaUbicaciones.add(claseProgramacion);
        listaUbicaciones.add(mountain);
        listaUbicaciones.add(playa);
        listaUbicaciones.add(edificio);
        listaUbicaciones.add(puente);
        listaUbicaciones.add(bosque);


        //añdimos el mapa a las ubicaciones
        //Llamamos a montaña con get(1)
        listaUbicaciones.get(1).addExit("N", 5);
        listaUbicaciones.get(1).addExit("S", 4);
        listaUbicaciones.get(1).addExit("E", 3);
        listaUbicaciones.get(1).addExit("O", 2);
        listaUbicaciones.get(1).addExit("Q", 0); // para salir

        //Playa
        listaUbicaciones.get(2).addExit("N", 5); // bosque
        listaUbicaciones.get(2).addExit("Q", 0); // para salir

        //Edificio
        listaUbicaciones.get(3).addExit("O", 1); // montaña
        listaUbicaciones.get(3).addExit("Q", 0); // para salir

        //Puente
        listaUbicaciones.get(4).addExit("N", 1); // montaña
        listaUbicaciones.get(4).addExit("O", 2); // playa
        listaUbicaciones.get(4).addExit("Q", 0); // para salir

        //Bosque
        listaUbicaciones.get(5).addExit("S", 1); //Montaña
        listaUbicaciones.get(5).addExit("O", 2); // Playa
        listaUbicaciones.get(5).addExit("Q", 0); // para salir
    }


    public static void main(String[] args) {
        Main main = new Main();



        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        int num = 1;

        System.out.println("Bienvenido");
        System.out.println(main.listaUbicaciones.get(num).getDescription());
        do {
            System.out.println("Tus direcciones válidas son: ");
            boolean coma= true;
            for (String direccion : main.listaUbicaciones.get(num).getExits().keySet()){
                if (!coma) {
                    System.out.print(", ");
                }else {
                    coma= false;
                }
                System.out.print(direccion);
            }



            System.out.println(" ");
            System.out.println("Selecciona una dirección ");
            String respUser= sc.next().toUpperCase();

            if (!respUser.equalsIgnoreCase("q")){
                for (Map.Entry<String,Integer > map : main.listaUbicaciones.get(num).getExits().entrySet()){
                    if (respUser.equalsIgnoreCase(map.getKey())){
                        num = map.getValue();
                    }
                }

                System.out.println(main.listaUbicaciones.get(num).getDescription());


            } else {
                System.out.println(main.listaUbicaciones.get(0).getDescription());
                continuar=false;
            }




        }while (continuar);


    }
    }

