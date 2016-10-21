package DYV;
public class Competicion {
    
    private int participantes;
    private int tabla [][];
    
    public int [][] getTabla(){
        return tabla;
    }
    
    /* La constructora Competición recibe un entero n(nº de participantes) como parámetro
     y muestra una tabla con el calendario de la competicion */
    public Competicion(int n) {
        participantes=n;
        // n es potencia de 2
        if (pdos(n)) {
            tabla=new int [n][n-1];
            formarTablaPdos(tabla,1,n);
        }
        // n no es potencia de 2
        else {
            // n es par
            if (n%2 == 0) {
                tabla = new int [n][n-1];
                formarTablaNoPdos(tabla,1,n);
                
            }
            // n es impar
            else{   tabla = new int [n+1][n];
                formarTablaNoPdos(tabla,1,n+1);
            }
        }
        //imprimir(tabla);
        //return tabla;
    }
    
    // Metodo que comprueba si un entero n es potencia de 2
    public boolean pdos(int n){
        int m=1;
        while (m<n){
            m=m*2;
        }
        if (m==n)return true;
        return false;
    }
    
    // Metodo que imprime la tabla de la competición
    public void imprimir(int tabla [][]){
        for (int i=0;i<participantes;i++){
            //for (int j=0;j<participantes-1;j++){
            for (int j=0;j<tabla[0].length;j++){
                System.out.print(tabla[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Metodo que forma la tabla de la competición para un nº de participantes potencia de 2
    public void formarTablaPdos(int tabla [][],int inf,int sup){
        int medio;
        if (inf==sup-1) {tabla[inf-1][0]=sup;
        tabla[sup-1][0]=inf;
        } else {
            medio=(inf+sup)/ 2;
            formarTablaPdos(tabla,inf,medio);
            formarTablaPdos(tabla,medio+1,sup);
            int diaini=sup-medio;
            int diafin=sup-inf;
            completarTabla(tabla,inf,medio,diaini,diafin,medio+1);
            completarTabla(tabla,medio+1,sup,diaini,diafin,inf);
        }
    }
    
    /* Metodo que forma la tabla de la competicion para un nº de participantes
       no potencia de 2. Recibe como parametros una tabla de enteros, el participante inferior y el superior */
    public void formarTablaNoPdos(int tabla [][],int inf,int sup){
        int medio;
        // Caso base
        if (inf==sup-1) {
            tabla[sup - inf-1][0]=sup;
            tabla[sup - inf][0]=inf;
        }
        // Caso recursivo
        else {
            // Calcula cual es la mitad de los elementos de la tabla
            int mitad = (sup - inf + 1)/2;
            // Calcula el elemento medio de la tabla
            medio=(inf+sup)/ 2;
            int tablaAuxInf [][];
            int tablaAuxSup [][];
            
            // La mitad es par
            if (mitad%2 == 0){
                // Crea las subtablas auxiliares Inferior y Superior de tamaño la mitad
                tablaAuxInf=new int [mitad][mitad - 1];
                tablaAuxSup=new int [mitad][mitad - 1];
                // LLama recursivamente al metodo formarTablaNoPdos
                formarTablaNoPdos(tablaAuxInf,inf,medio);
                formarTablaNoPdos(tablaAuxSup,medio+1,sup);
                // Combina las tablas Inferior y Superior en una unica tabla
                CombinarPar(tablaAuxInf,tablaAuxSup,tabla);
                // Completa los elementos restantes de la tabla
                int diaini=sup-medio;
                int diafin=sup-inf;
                completarTabla(tabla,1,mitad,diaini,diafin,medio+1);
                completarTabla(tabla,mitad+1,sup-inf+1,diaini,diafin,inf);
            }
            
            // La mitad es impar
            else{
                medio = medio + 1;
                /* Crea las subtablas auxiliares Inferior y Superior de tamaño la mitad + 1
                   Se añade un elemento a la tabla para que sea de longitud par*/
                tablaAuxInf=new int [mitad+1][mitad];
                tablaAuxSup=new int [mitad+1][mitad];
                // LLama recursivamente al metodo formarTablaNoPdos
                formarTablaNoPdos(tablaAuxInf,inf,medio);
                formarTablaNoPdos(tablaAuxSup,medio,sup+1);
                // Combina las tablas Inferior y Superior en una unica tabla
                CombinarImpar(tablaAuxInf, medio,tablaAuxSup, sup+1,tabla);
                int diaini=sup+1-medio+1;
                int diafin=sup-inf;
                // Completa los elementos restantes de la tabla
                completarTablaSup(tabla,1,mitad,diaini,diafin,medio+1);
                completarTablaInf(tabla,mitad+1,sup-inf+1,diaini,diafin,inf);
            }
        }
    }
    
    // Metodo que completa los elementos de la parte derecha de una tabla par
    public void completarTabla(int tabla [][],int eqInf,int eqSup,int diaini,int diafin,int eqInic){
        for (int j=diaini;j<=diafin;j++){
            tabla[eqInf-1][j-1]=eqInic+j-diaini;
        }
        for (int i=eqInf;i<eqSup;i++){
            tabla[i][diaini-1]=tabla[i-1][diafin-1];
            for (int k=diaini+1;k<=diafin;k++){
                tabla[i][k-1]=tabla[i-1][k-2];
            }
        }
    }
    // Metodo que completa los elementos de la parte superior derecha una tabla impar
    public void completarTablaSup(int tabla [][],int eqInf,int eqSup,int diaini,int diafin,int eqInic){
        for (int j=diaini;j<=diafin;j++){
            tabla[eqInf-1][j-1]=eqInic+j-diaini;
        }
        for (int i=eqInf;i<eqSup;i++){
            tabla[i][diafin-1]=tabla[0][(diaini-3)+i];
            for (int k=diaini;k<diafin;k++){
                tabla[i][k-1]=tabla[i-1][k];
            }
        }
    }
    // Metodo que completa los elementos de la parte inferior derecha una tabla impar
    public void completarTablaInf(int tabla [][],int eqInf,int eqSup,int diaini,int diafin,int eqInic){
        for (int j=diaini;j<=diafin;j++){
            tabla[eqInf-1][j-1]=eqInic+eqSup-j;
        }
        for (int i=eqInf;i<eqSup;i++){
            tabla[i][diaini-1]= i + eqInic - eqInf ; //tabla[i-1][eqSup-i];
            for (int k=diaini+1;k<=diafin;k++){
                tabla[i][k-1]=tabla[i-1][k-2];
            }
        }
    }
    // Metodo que combina 2 tablas de numeros enteros de igual longitud en una tabla mas grande
    public void CombinarPar(int tablaAux1[][], int tablaAux2[][], int tabla[][]){
        int k,i;
        // Tabla Auxiliar Inferior
        for(i=0;i<tablaAux1.length;i++)
            for(int j=0;j<tablaAux1[0].length;j++)
                tabla[i][j] = tablaAux1[i][j];
        // Tabla Auxuliar Superior
        for(k=i;k<tabla.length;k++)
            for(int j=0;j<tablaAux2[0].length;j++)
                tabla[k][j] = tablaAux2[k-i][j];
    }
    
          /* Metodo que combina 2 tablas de numeros enteors de igual longitud en una tabla mas grande de longitud impar
           cambia los elementos "fantasma" por el elemento correspondiente a la posicion de la tabla*/
    public void CombinarImpar(int tablaAux1[][],int fantasma1, int tablaAux2[][], int fantasma2, int tabla[][]){
        int k,i;
        // Tabla Auxiliar Inferior
        for(i=0;i<tablaAux1.length-1;i++)
            for(int j=0;j<tablaAux1[0].length;j++){
            if(tablaAux1[i][j] == fantasma1) tabla[i][j] = tablaAux2[tablaAux2.length-1][j];
            else tabla[i][j] = tablaAux1[i][j];
            
            }
        // Tabla Auxiliar Superior
        for(k=i;k<tabla.length;k++)
            for(int j=0;j<tablaAux2[0].length;j++){
            if(tablaAux2[k-i][j] == fantasma2) tabla[k][j] = tablaAux1[tablaAux1.length-1][j];
            else tabla[k][j] = tablaAux2[k-i][j];
            }
    }
    
}
