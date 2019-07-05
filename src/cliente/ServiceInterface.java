package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {

    float subtracao(float a, float b) throws RemoteException;

    float soma(float a, float b, float c) throws RemoteException;

    float multiplicacao(float[] v) throws RemoteException;

    float[][] transformaMatriz(float[][] m) throws RemoteException;
}
