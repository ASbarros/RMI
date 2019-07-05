package servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceMain {

    public static void main(String[] args) {

        run(2020, "Service_01");
        run(2021, "Service_02");
        run(2022, "Service_03");
        run(2023, "Service_04");
        run(2024, "Service_05");
        run(2025, "Service_06");
        run(2026, "Service_07");
        run(2027, "Service_08");
        run(2028, "Service_09");
    }

    public static void run(int pPort, String nome) {
        try {
            ServiceInterface objServiceInterface = new ServiceImpl();
            Registry registry = LocateRegistry.createRegistry(pPort);

            //ligacao ao objeto que tem referenciados os metodos 
            registry.bind(nome, objServiceInterface);

            //mostra as infos do servidor
            System.out.println("Respondendo: " + nome + " Port: " + pPort);
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
