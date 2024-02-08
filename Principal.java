

import javax.swing.JOptionPane;
public class Principal 
{
    
    public static void main(String[] args)
    {   
        Principal p = new Principal();
        p.menu();    
    }
        public void menu()
        {
            Lista l = new Lista(); //OBJETO CLASE LISTA
            int opc = 0,dato,datoabuscar=0;
            do{
                String val = JOptionPane.showInputDialog(" 1. Insertar al inicio\n 2. Insertar al final\n 3. Insertar en medio\n 4. Eliminar al inicio\n 5. Eliminar al final \n 6. Eliminar en medio\n 7. Mostrar los datos ingresados\n 8. Contar el numero de nodos\n 9. Buscar un dato\n 0. Salir");
                //opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Insertar al inicio\n 2. Insertar al final\n 3.Eliminar al inicio\n 4.Eliminar al final\n 5.Mostrar los datos ingresados\n 6. Contar el numero de nodos\n 0.Salir","MENU DE OPCIONES",JOptionPane.INFORMATION_MESSAGE));
                if(val == null)
                {
                    l.cerrar();
                }
                else{
                    opc = Integer.parseInt(val);
                switch (opc)
                {
                    case 1: //Opcion para insertar un nuevo nodo al inicio de la lista
                        dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el dato", "Incersion de dato", JOptionPane.DEFAULT_OPTION));    
                        l.insertarInicio(dato);
                        break;
                    case 4: //Eliminar un nodo del inicio de la lista
                        l.eliminarInicio();
                        break;
                    case 2: //Opcion para insertar un nuevo nodo al inicio de la lista
                        dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el dato", "Incersion de dato", JOptionPane.DEFAULT_OPTION));  
                        l.insertarFinal(dato);
                        break;
                    case 3: 
                        dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el dato", "Incersion de dato", JOptionPane.DEFAULT_OPTION));  
                        l.insertarEnMedio(dato);
                        break;
                        
                    case 5: //Eliminar un nodo del inicio de la lista
                        l.eliminarFinal();
                        break;   
                    case 6:
                        l.eliminarEnMedio();
                        break; 
                    case 7: //Mostrar lista
                        l.mostrar();
                        break;
                    case 8: //Mostrar lista
                        l.contarNodos();
                        break; 
                    case 9:
                        datoabuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el dato a buscar", "Busqueda de dato", JOptionPane.DEFAULT_OPTION));
                        l.buscarDato(datoabuscar);  
                        break; 
                    case 0: 
                        l.cerrar();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "ESTA OPCION NO EXISTE, FAVOR DE DIGITAR UNA VALIDA", "ERROR",JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
                }while(opc!=0);
        }
    
    
}
