package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import servidor.ServiceInterface;

public class ClienteMain {

    public static void main(String[] args) {

        try {
            float[][] matrizUsuario = new float[3][3];
            float[][] matrizTransformada = new float[3][5];
             Scanner scan = new Scanner(System.in);
             //insercao dos elementos da matriz pelo usuario...
             for (int i = 0; i < 3; i++) {
                   for (int j = 0; j < 3; j++) {
                       System.out.println("Digite o elemento na posição: " + i + "X" + j);
                       matrizUsuario[i][j] = scan.nextFloat();
                 }
              }
             // matriz carregada de modo estatico...
             // matrizUsuario[0][0] = 2;
             // matrizUsuario[0][1] = 3;
             // matrizUsuario[0][2] = 1;
             // matrizUsuario[1][0] = 1;
             // matrizUsuario[1][1] = 2;
             // matrizUsuario[1][2] = 4;
             // matrizUsuario[2][0] = 0;
             // matrizUsuario[2][1] = 5;
             // matrizUsuario[2][2] = 1;
            int port1 = 2020;
            int port2 = 2021;
            int port3 = 2022;
            int port4 = 2023;
            int port5 = 2024;
            int port6 = 2025;
            int port7 = 2026;
            int port8 = 2027;
            int port9 = 2028;
            // Registrar a conexao com o servidor
            Registry registry1 = LocateRegistry.getRegistry("localhost", port1);
            Registry registry2 = LocateRegistry.getRegistry("localhost", port2);
            Registry registry3 = LocateRegistry.getRegistry("localhost", port3);
            Registry registry4 = LocateRegistry.getRegistry("localhost", port4);
            Registry registry5 = LocateRegistry.getRegistry("localhost", port5);
            Registry registry6 = LocateRegistry.getRegistry("localhost", port6);
            Registry registry7 = LocateRegistry.getRegistry("localhost", port7);
            Registry registry8 = LocateRegistry.getRegistry("localhost", port8);
            Registry registry9 = LocateRegistry.getRegistry("localhost", port9);

            // A partir da conexao, obter o objeto stub para executar os metodos remotos
            ServiceInterface stub1 = (ServiceInterface) registry1.lookup("Service_01");
            ServiceInterface stub2 = (ServiceInterface) registry2.lookup("Service_02");
            ServiceInterface stub3 = (ServiceInterface) registry3.lookup("Service_03");
            ServiceInterface stub4 = (ServiceInterface) registry4.lookup("Service_04");
            ServiceInterface stub5 = (ServiceInterface) registry5.lookup("Service_05");
            ServiceInterface stub6 = (ServiceInterface) registry6.lookup("Service_06");
            ServiceInterface stub7 = (ServiceInterface) registry7.lookup("Service_07");
            ServiceInterface stub8 = (ServiceInterface) registry8.lookup("Service_08");
            ServiceInterface stub9 = (ServiceInterface) registry9.lookup("Service_09");
            // stub conhece a lista de metodos implementado no servidor

            // invocao do metodo remoto
            matrizTransformada = stub1.transformaMatriz(matrizUsuario);

            float[] v1 = new float[3];
            float[] v2 = new float[3];
            float[] v3 = new float[3];
            float[] v4 = new float[3];
            float[] v5 = new float[3];
            float[] v6 = new float[3];
            v1[0] = matrizTransformada[0][0];
            v1[1] = matrizTransformada[1][1];
            v1[2] = matrizTransformada[2][2];

            v2[0] = matrizTransformada[0][1];
            v2[1] = matrizTransformada[1][2];
            v2[2] = matrizTransformada[2][3];

            v3[0] = matrizTransformada[0][2];
            v3[1] = matrizTransformada[1][3];
            v3[2] = matrizTransformada[2][4];

            v4[0] = matrizTransformada[2][0];
            v4[1] = matrizTransformada[1][1];
            v4[2] = matrizTransformada[0][2];

            v5[0] = matrizTransformada[2][1];
            v5[1] = matrizTransformada[1][2];
            v5[2] = matrizTransformada[0][3];

            v6[0] = matrizTransformada[2][2];
            v6[1] = matrizTransformada[1][3];
            v6[2] = matrizTransformada[0][4];
            
            System.out.println(
                    stub1.subtracao(
                            stub2.soma(stub3.multiplicacao(v1), stub4.multiplicacao(v2), stub5.multiplicacao(v3)),
                            stub6.soma(stub7.multiplicacao(v4), stub8.multiplicacao(v5), stub9.multiplicacao(v6)
                            )
                    )
            );
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
