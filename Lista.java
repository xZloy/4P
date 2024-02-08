import javax.swing.JOptionPane;

public class Lista 
{
    public Nodo inicio;
    public int contador;
    //Constructor lista
    public Lista()
    {
        inicio = null; //se inicializa la lista
        contador =0;
    }
   
    //Este mÃ©todo nos inidica si la lista se encuentra vacia
    public boolean estaVacia()
    {
        if (inicio == null)
           return true;
        else
           return false;
    }
   
    //Metodo para insertar un nuevo Nodo al inicio al inicio de lista
    public void insertarInicio(int dato)
    {
        Nodo nuevo; //Definimos un elemento de tipo nodo
        if (estaVacia())//Verificamos si la lista esta vacia
        {
            //si esta vacia se crea el primer elemento de la lista
            nuevo = new Nodo (dato, null);
            inicio = nuevo;
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el nodo", "NODO INSERTADO",JOptionPane.INFORMATION_MESSAGE);
            
        }
        else //Si no se encuentra vacia se inserta un elemento al inicio de la Lista
        {
            nuevo = new Nodo(dato, null); //Se crea el nuevo nodo
            nuevo.setSiguiente(inicio); //Apuntamos el nuevo nodo al nodo inicio
            inicio = nuevo; //Hacemos que inicio sea el nuevo nodo
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el nodo al inicio", "NODO INSERTADO",JOptionPane.INFORMATION_MESSAGE);
        }
        contador++;
    }
    public void insertarFinal(int x)
    {
        Nodo a;
        a = new Nodo(x, null);
        if(estaVacia())
        {
            //Si la lista esta vacia se inserta el primer dato.
            inicio = a;
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el nodo", "NODO INSERTADO",JOptionPane.INFORMATION_MESSAGE);
        }
        else //Insertar x al final de la lista.
        {
            Nodo b = inicio;
            while(b.getSiguiente()!=null)
            {
                b = b.getSiguiente();
            }
            b.setSiguiente(a);
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el nodo al final", "NODO INSERTADO",JOptionPane.INFORMATION_MESSAGE);

        }
        contador++;
    }

    public void insertarEnMedio(int z)
    {
        Nodo a = new Nodo(z, null);
       
        if(estaVacia())
        {
            //Si la lista esta vacia se inserta el primer dato.
            inicio = a;
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el nodo", "NODO INSERTADO",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(estaVacia()==false && contador<2)
        {
            JOptionPane.showMessageDialog(null, "La no lista no cuenta con el tamaño minimo necesario para poder hacer eso","Lista",JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int recorrer = contador/2;
            Nodo actual = inicio;
            Nodo anterior = null;
            for(int i=0;i<recorrer;i++)
            {
                    anterior = actual;
                    actual = actual.getSiguiente();
            }
            a.setSiguiente(actual); 
            anterior.setSiguiente(a);
        }
        contador++;

    }
    public void eliminarEnMedio()
    {
        if(estaVacia()==true  || inicio.getSiguiente()==null)
        {
            JOptionPane.showMessageDialog(null, "Esta vacia la lista o solo tiene un nodo", "Eliminacion fallida",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Nodo lento = inicio;    // ESTE SE MOVERA UNO A LA VEZ
            Nodo rapido = inicio;  // ESTE SE MOVERA DOS POSICIONES
            Nodo prev = null;       //ESTE SE IGUALARA A LENTO
            while (rapido!=null && rapido.getSiguiente()!=null)
            {
                rapido = rapido.getSiguiente().getSiguiente();
                prev = lento;
                lento = lento.getSiguiente();
            }
            prev.setSiguiente(lento.getSiguiente()); //EL VALO DE LENTO-1(DEL WHILE) TOMARA DE BASE Y LUEGO SE ELIMINARA EL QUE ESTA ADELANTE
            contador--;
        }

    }

   
    //MÃ©todo para eliminar el primer nodo de la lista
    public void eliminarInicio()
    {
        if(estaVacia())
        {
            JOptionPane.showMessageDialog(null, "La lista se encuestra vacia", "LISTA VACIA",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            inicio = inicio.getSiguiente(); //Se recorre o avanza al siguiente nodo
            contador--;
        }
    }
    public void eliminarFinal()
    {
        if(estaVacia())
        {
            JOptionPane.showMessageDialog(null, "La lista se encuestra vacia", "LISTA VACIA",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            Nodo n = inicio;
            while(n.getSiguiente().getSiguiente()!=null)
            {
                n = n.getSiguiente();
            }
            n.setSiguiente(null); 
            contador --;
        }
    }
   
    //MÃ©todo para mostra lista
    public void mostrar()
    {
        Nodo temporal;
        if (estaVacia())
        {
            JOptionPane.showMessageDialog(null, "La lista se encuestra vacia", "LISTA VACIA",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            String concat = " ";
            int contador2=0;
            temporal = inicio; // se estaciona temporal en el inicio de la lista
            while (temporal != null)
            {        
                concat = concat + "Posicion:"+contador2+" ==> "+temporal.getDato()+"\n ";
                temporal = temporal.getSiguiente();
                contador2++;
            }
            JOptionPane.showInternalMessageDialog(null, concat, "Lista", JOptionPane.OK_OPTION);
        }
    }
    public void contarNodos()
    {
        JOptionPane.showMessageDialog(null, "El numero de nodos es: "+contador, "Numero de nodos",JOptionPane.INFORMATION_MESSAGE);
    }
    public void cerrar()
    {
        int closeornot=JOptionPane.showConfirmDialog(null, "Seguro que desea cerrar el programa?", "Fin del programa", JOptionPane.YES_NO_OPTION);
                if(closeornot== JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Hasta luego!", "Fin del programa",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    Principal p = new Principal();
                    p.menu();
                    }
    }
    public void buscarDato(int dato)
    {
        Nodo actual = inicio;
        int posicion = 0;
        boolean encontrado = false;
        while (actual != null) {
            if (actual.getDato() == dato) {
                encontrado = true;
                break;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El elemento " + dato + " se encuentra en la posición " + posicion, "Resultado de busqueda", JOptionPane.OK_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "El elemento " + dato + " no se encuentra en la lista", "Resultado de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
