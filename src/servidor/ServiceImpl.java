package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements
        ServiceInterface {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ServiceImpl() throws RemoteException {
        super();
    }

    /**
     * Métodos remotos
     */

    public float soma(float a, float b, float c) throws RemoteException {
        return a + b + c;
    }

    public float subtracao(float a, float b) throws RemoteException {
        return a - b;
    }

    public float multiplicacao(float v[]) {
        return v[0]*v[1]*v[2];
    }

    public float[][] transformaMatriz(float[][] matrizUsuario) {
        float[][] novaMatriz = new float[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0, aux = 0; j < 5; j++, aux++) {
                aux = (aux == 3) ? 0 : aux; 
                novaMatriz[i][j] = matrizUsuario[i][aux];
            }
        }
        return novaMatriz;
    }
}
