import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class CalculetteServeur extends UnicastRemoteObject implements CalculetteInterface {
    protected CalculetteServeur() throws RemoteException {
        super();
    }

    @Override
    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new RemoteException("Division par zéro");
        }
    }

    public static void main(String[] args) {
        try {
            CalculetteServeur serveur = new CalculetteServeur();

            //RMI registry on port 1099 (default RMI registry port)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Binding the server object to the registry with the name "CalculetteServeur"
            registry.rebind("CalculetteServeur", serveur);

            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


