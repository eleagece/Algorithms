package Metropolitano; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Grafo 
 {
 public int grafo[][];
 public boolean desactivadas[];
 public int grafoEstatico[][];
 public Hashtable thEstaciones;
 public Hashtable thCodigos;
 
 public Grafo(int matrizAdy[][], Hashtable the, Hashtable thc)  {
  //grafo = matrizAdy;
  grafoEstatico = matrizAdy;
  //grafo = grafoEstatico.clone();
  grafo = new int[grafoEstatico.length][grafoEstatico.length];
  for(int i=0;i<grafo.length;i++)
      for(int j=0;j<grafo.length;j++)
          grafo[i][j] = grafoEstatico[i][j];
  desactivadas = new boolean[grafo.length];
  for(int i= 0; i<desactivadas.length;i++) desactivadas[i] = false;
  //grafoEstatico = new int[grafo.length][grafo.length];
  //grafoEstatico = grafo.clone();
  
  thEstaciones = the;
  thCodigos = thc;
  }
    
 public int dameTamano()
  {
  return grafo.length;    
  }
 public Hashtable dameThCodigos()
  {
  return thCodigos;   
  }
 public Hashtable dameThEstaciones()
  {
  return thEstaciones;   
  } 
 
public int distanciaConjunto(int vertices[]){
    int i=0;
    int distancia=0;
    boolean error=false;
     while(i < vertices.length-1 && !error){
        int v1 = vertices[i];
        int v2 = vertices[i+1];
        int aux = grafo[v1][v2];
        if(aux>0) distancia = distancia + aux;
        else {
            error = true;
            distancia = 0;
        }
        i++;
        }
     
    return distancia;
     }
 
public ArrayList trayectosDos(int N1, int N2){
    boolean vertices[] = new boolean [grafo.length];
    for (int i= 0; i<vertices.length; i++) vertices[i] = true;
    vertices[N1] = false;    
    
     ArrayList trayecto = new ArrayList();
     ArrayList lista = new ArrayList();    
    trayecto.add(N1);    
    return trayectosDosRec(N1,N2,vertices,trayecto,lista);
}

private ArrayList trayectosDosRec(int N1, int N2, boolean vertices[],ArrayList trayecto, ArrayList lista){
    for(int i=0; i<grafo.length;i++){
        int hijo = i;
        if(grafo[N1][i]>0 && vertices[hijo]){            
            if (hijo==N2){
                trayecto.add(hijo);
                ArrayList trayectoAux = (ArrayList) trayecto.clone();      
                lista.add(trayectoAux);
                trayecto.remove(trayecto.size()-1);
            }
            else{
                vertices[hijo] = false;
                trayecto.add(hijo);
                lista = trayectosDosRec(hijo,N2,vertices,trayecto,lista);
                trayecto.remove(trayecto.size()-1);
                vertices[hijo] = true;
            }
        }
    }
    return lista;
 }

public ArrayList todosTrayectosDos(int N1,int N2, ArrayList vertices){//int vertices[]){
    ArrayList listaTrayectos = trayectosDos(N1,N2);
    ArrayList listaTrayectosBuenos = new ArrayList();
    for (int i=0; i<listaTrayectos.size();i++){
        ArrayList trayecto = (ArrayList) listaTrayectos.get(i);
        if (pasaPor(trayecto,vertices)) listaTrayectosBuenos.add(trayecto);
    }
    return listaTrayectosBuenos;
}

private boolean pasaPor(ArrayList trayecto,ArrayList vertices){//int vertices[]){
    int coincidencias = 0;
    int i = 0;
    while(i<trayecto.size() && coincidencias < vertices.size() ){
        boolean coincide = false;
        int j = 0;
        while(j<vertices.size() && !coincide) {
            coincide = ((Integer) trayecto.get(i) == vertices.get(j));
            if(coincide) coincidencias++;
            j++;
        }
        i++;
    }
    return (coincidencias == vertices.size());
}

public void kruskal(boolean sol[][]){
    int particion[] = new int[grafo.length];
    int c1,c2;
    Item grafo2[] = new Item[(grafo.length*(grafo.length - 1)) / 2 ];
    int narcos;
    int p[] = new int[grafo.length];
    InicParticion(p);
    narcos = Ordenar(grafo,grafo2);
    int i=0;
    while(!FinParticion(p) && i<narcos){
        c1 = ObtenerComponente(p,grafo2[i].origen);
        c2 = ObtenerComponente(p,grafo2[i].destino);
        if(c1 != c2){
            Fusionar(p,c1,c2);
            sol[grafo2[i].origen][grafo2[i].destino] = true;
        }
        i++;
    }
}

private void InicParticion(int p[]){
    for(int i=0; i<p.length;i++) p[i]=i;
}

private void Fusionar(int p[], int a, int b){
    if(a>b){
        int temp = a; a=b; b=temp;
    }
    for(int i=0;i<p.length;i++)
        if(p[i]==b) p[i]=a;
}

private boolean FinParticion(int p[]){
    for (int i=0;i<p.length;i++)
        if(p[i] != 1) return false;
    return true;
}

private int ObtenerComponente(int p[],int i){
    return p[i];
}

private int Ordenar(int g[][], Item g2[]){
    int narcos=0;
    for (int i=0; i<g.length-1;i++){
        for (int j=i+1;j<g.length;j++){
            if(g[i][j] != 0){
                Item it = new Item(i,j,g[i][j]);
                g2[narcos] = it;
                narcos++;
                
            }
        }
    }
    //Insercion(g2,0,narcos-1);
    Arrays.sort(g2,0,narcos);
    return narcos;
}

public void Insercion(Item a[], int prim, int ult){
    for(int i=prim+1;i<=ult;i++){
        Item x=a[i];
        int j=i-1;
        while(j>=prim && x.peso<a[j].peso){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=x;        
    }
}

 public ArrayList dijkstra(int matriz[][])
  {
  //***** dijkstra() **********************************************************//
  //*** Pasado un grafo (en forma de matriz de adyacencia) devuelve los     ***//
  //*** trayectos mínimos desde el primer vértice al resto.                 ***//
  //***************************************************************************//
  //*** Para funcionar necesita tres listas. Una (listaVertices) de vérti-  ***//
  //*** ces seleccionados/no seleccionados, otra (listaDistancias) de dis-  ***//
  //*** tancias mínimas desde el primer vértice al resto y una última (lis- ***//
  //*** taTrayectos) que guarda los trayectos mínimos desde el primer vér-  ***//
  //*** tice al resto.                                                      ***//
  //***************************************************************************//                                   
  //*** En la INICIALIZACIÓN listaDistancias y listaTrayectos se actualizan ***//
  //*** según la matriz de adyacencia con los datos de la primera fila y    ***//
  //*** listaVertices tiene seleccionado el primer vértice.                 ***//
  //***************************************************************************//
  //*** En los PASOS se lleva un bucle exterior (i) para ir modificando     ***//
  //*** listaVertices. Y se lleva un bucle interior (j) para ir actualizan- ***//
  //*** do listaDistancias y listaTrayectos según el vértice seleccionado   ***//
  //*** con el bucle exterior.                                              ***//
  //***************************************************************************//
  // INICIALIZACIÓN
  int numVertices=matriz.length;  // Devuelve el número de vértices
  boolean listaVertices[]=new boolean[numVertices];  // Conjunto de vértices seleccionadas/no seleccionadas  
  int listaDistancias[]=new int[numVertices-1];  // Conjunto de todas las distancias mínimas desde un vértice a todos los demás
  ArrayList listaTrayectos=new ArrayList();  // Guardamos una lista de trayectos mínimos dinámica
  listaVertices[0]=true;  // Primer vértice seleccionado
  for (int i=1; i<numVertices; i++)  // Bucle para inicializar listaVertices, listaDistancias y listaTrayectos
   {
   listaVertices[i]=false;  // Ponemos el resto de vértices deseleccionados 
   listaDistancias[i-1]=matriz[0][i];  // Y en la lista de distancias actualizamos
   listaTrayectos.add(new ArrayList());  // En listaTrayectos, cada elemento será un ArrayList de int
   ArrayList trayecto=(ArrayList)listaTrayectos.get(i-1);  // Para poder manejar ese ArrayList de int hay que sacarlo a una variable ArrayList llamada trayecto
   trayecto.add(0);  // Añadimos el primer entero que será siempre el primer vértice (0)
   if (matriz[0][i]!=0)  // Si en la matriz el primer vértice está enganchado a cualquier otro lo añadimos
    {
    trayecto.add(i);
    }
   }
  // PASOS
  for (int i=1; i<numVertices-1; i++)  // Bucle exterior, actualiza listaVertices, encargándose de elegir un vértice referencia
   {                                   // con pos, además de ponerlo a true para que no sea usado en el futuro
   int pos=0;  
   pos=vertMasCercano(listaDistancias,listaVertices); 
   listaVertices[pos]=true;  
   for (int j=1; j<numVertices; j++)  // Bucle interior, actualizar listaDistancias y listaTrayectos, en relación al vértice seleccionado con  
    {                                 // el bucle exterior (vértice pos)
    if (listaVertices[j]==false && matriz[pos][j]!=0)  // Si el vértice que tratamos aún no ha sido seleccionado y
     {                                                 // está enganchado con el que estamos comparando...
     if (listaDistancias[j-1]==0)  // Si en listaDistancias teníamos un 0 no debemos llamar a la función
      {                            // min porque nos haría mal el mínimo
      listaDistancias[j-1]=listaDistancias[pos-1]+matriz[pos][j];  // Así que actualizamos directamente
      ArrayList trayecto=(ArrayList)listaTrayectos.get(j-1);  // Sacamos el trayecto que vamos a actualizar
      ArrayList trayectoAnterior=(ArrayList)listaTrayectos.get(pos-1);  // Sacamos el trayecto que vamos a usar para actualizar
      for (int k=1; k<trayectoAnterior.size(); k++)  // Recorremos sus elementos para copiarlos
       {
       int elemento=(Integer)trayectoAnterior.get(k);
       trayecto.add(elemento);
       }
      trayecto.add(j);
      }
     else  // if (listaDistancias[j-1]!=0)  // Si en listaDistancias teníamos algo distinto de cero debemos hallar el mínimo de la expresión
      {                                     // para actualizar bien la distancia
      boolean b=listaDistancias[pos-1]+matriz[pos][j]<listaDistancias[j-1];   
      listaDistancias[j-1]=min(listaDistancias[j-1],listaDistancias[pos-1]+matriz[pos][j]);
      if (b)  // Si hemos encontrado una distancia menor que la que había en listaDistancias actualizamos
       {
       ArrayList trayecto=(ArrayList)listaTrayectos.get(j-1);  // Sacamos el trayecto que vamos a actualizar
       int ultimoElemento=(Integer)trayecto.get(trayecto.size()-1);  // Sacamos el último entero de la listaTrayectos
       int tamanoOriginalTrayecto=trayecto.size();  // Guardamos el tamaño original para poder borrar elementos del ArrayList con un for
       for (int l=1; l<tamanoOriginalTrayecto-1; l++)
        {
        trayecto.remove(1);   
        }
       trayecto.remove(trayecto.size()-1);  // ...lo eliminamos
       ArrayList trayectoAnterior=(ArrayList)listaTrayectos.get(pos-1);  // Sacamos el trayecto que vamos a usar para actualizar
       for (int k=1; k<trayectoAnterior.size(); k++)  // Recorremos sus elementos para copiarlos
        {
        int elemento=(Integer)trayectoAnterior.get(k);
        trayecto.add(elemento);
        }
       trayecto.add(ultimoElemento);
       }  // fin if actualizador de listaTrayectos
      }  // fin if diferenciador si hay ceros en listaDistancias
     }  // fin if de comprobación de vértice no seleccionado y enganchado
    }  // fin for interior (j)
   }  // fin for exterior (i)
  return listaTrayectos;
  }
 public int vertMasCercano(int listaDistancias[], boolean listaVertices[])
  {
  //***** vertMasCercano() ****************************************************//
  //*** Estamos analizando un vértice origen. El método devuelve la posi-   ***//
  //*** ción del vértice más cercano y no seleccionado al vértice origen en ***//
  //*** relación a listaVertices y listaDistancias.                         ***//
  //***************************************************************************//
  int numVertices=listaVertices.length;  // Número de vértices de listaVertices
  int menorDistancia=Integer.MAX_VALUE;  
  int pos=1;
  for (int i=1; i<numVertices; i++)  // Recorre la lista de distancias para sacar  
   {                                 // la más cercana al vértice origen
   if (listaVertices[i]==false && listaDistancias[i-1]<menorDistancia && listaDistancias[i-1]>0)
    {
    menorDistancia=listaDistancias[i-1];
    pos=i;
    }
   }
  return pos;
  }
 private int min(int a, int b)
  {
  //***** min() ***************************************************************//
  //*** Devuelve el más pequeño de los dos enteros pasados por parámetro    ***//
  //***************************************************************************//
  if (a<b)
   {
   return a;
   }
  else
   {
   return b;   
   }
  }
 public int[][] transformarGrafo(int n)
  {
  //***** transformarGrafo() **************************************************//
  //*** Método que recibe como parámetro la posición de un vértice del gra- ***//
  //*** fo. Devuelve la matriz de adyacencia de ese grafo reordenada de tal ***//
  //*** forma que ese vértice pasa a ser el primero. La finalidad de este   ***//
  //*** método es ampliar el uso del algoritmo de dijkstra, ya que sabemos  ***//
  //*** calcula las distancias mínimas desde el primer vértice del grafo    ***//
  //***************************************************************************//
  int numVertices=grafo.length;  // Devuelve el número de vértices del grafo original
  int matrizTransformada[][]=new int[numVertices][numVertices];  // Crea un grafo vacío del mismo tamaño del original
  int filT=0;
  int colT=0;
  for (int fil=0; fil<numVertices; fil++)  // Reordena la matriz de adyacencia
   {
   for (int col=0; col<numVertices; col++)   
    {
    if (numVertices-n+fil<numVertices)
     {
     colT=numVertices-n+fil;   
     }
    else
     {
     colT=fil-n;   
     }
    if (numVertices-n+col<numVertices)
     {
     filT=numVertices-n+col;   
     }  
    else
     {
     filT=col-n;   
     }
    matrizTransformada[filT][colT]=grafo[fil][col];     
    }
   }
  return matrizTransformada;  // Devuelve la matriz de adyacencia reordenada
  }
 public ArrayList detransformarLista(ArrayList listaTrayectosTr, int origen)
  {
  //***** detransformarLista() ************************************************//
  //*** Al haber usado transformarGrafo para a su vez poder usar dijkstra   ***//
  //*** se crea un problema de vértices transformados. Hay que devolverlos  ***//
  //*** a su estado original para poder luego encontrar los trayectos mí-   ***//
  //*** nimos fácilmente.                                                   ***//
  //***************************************************************************//
  for (int i=0; i<listaTrayectosTr.size(); i++) // For para recorrer la listaTrayectos
   {
   ArrayList trayecto=new ArrayList();  // Sacamos el trayecto que estamos analizando
   trayecto=(ArrayList)listaTrayectosTr.get(i);
   for (int j=0; j<trayecto.size(); j++)
    {
    int vertice=(Integer)trayecto.get(j);
    if (vertice+origen<=listaTrayectosTr.size())  
     {
     trayecto.set(j,vertice+origen);
     }
    else  // if (distancia+origen>listaTrayectosTr.size()) 
     {
     trayecto.set(j,vertice+origen-(listaTrayectosTr.size()+1));   
     }
    }
   }
  return listaTrayectosTr;
  }
 public ArrayList trayectoMinimo(int origen, int destino)
  {
  //***** trayectoMinimo() ****************************************************//
  //*** Devuelve en un ArrayList el trayecto más corto entre el vértice     ***//
  //*** origen y el vértice destino. El ArrayList devuelto es un conjunto   ***//
  //*** ordenado de vértices desde el vértice origen al vértice destino.    ***//
  //***************************************************************************//
  int numVertices=grafo.length;
  if (origen==0)
   {
   ArrayList listaTrayectos=new ArrayList();
   ArrayList trayectoMinimo=new ArrayList();
   listaTrayectos=dijkstra(grafo);
   trayectoMinimo=(ArrayList)listaTrayectos.get(destino-1);
   return trayectoMinimo;
   }
  else  // if (origen!=0)
   {
   ArrayList listaTrayectos=new ArrayList();
   ArrayList listaTrayectosTr=new ArrayList();
   ArrayList trayectoMinimo=new ArrayList();
   int matrizTransformada[][]=transformarGrafo(origen);
   listaTrayectosTr=dijkstra(matrizTransformada);
   listaTrayectos=detransformarLista(listaTrayectosTr,origen);  // Hasta aquí bien WOWOWOWOWOWOWOWOWOWOW
   boolean encontrado=false;
   int i=0;
   while (!encontrado)
    {
    ArrayList trayecto=new ArrayList();
    trayecto=(ArrayList)listaTrayectos.get(i);
    int vertice=(Integer)trayecto.get(trayecto.size()-1);
    if (vertice==destino)
     {
     encontrado=true;
     trayectoMinimo=trayecto;
     }
    i++;   
    }
   return trayectoMinimo;
   }
  }
 public ArrayList trayectoMinimoIntermedio(int origen, int destino, ArrayList vertIntermedios)
  {
  //***** trayectoMinimoIntermedio() ******************************************//
  //*** Devuelve en un ArrayList el trayecto más corto entre el vértice     ***//
  //*** origen y el vértice destino pasando por estaciones intermedias. El  ***//
  //*** ArrayList devuelto es un conjunto ordenado de vértices desde el     ***//
  //*** vértice origen al vértice destino con los vértices intermedios      ***//
  //***************************************************************************//
  ArrayList trayectoMinimoIntermedio=new ArrayList();
  ArrayList trayectoAuxiliar=new ArrayList();
  trayectoMinimoIntermedio=trayectoMinimo(origen,(Integer)vertIntermedios.get(0));  // Trayecto mínimo desde el origen a la primera estación intermedia
  for (int i=0; i<vertIntermedios.size()-1; i++)  // Trayectos intermedios mínimos
   {
   trayectoAuxiliar=trayectoMinimo((Integer)vertIntermedios.get(i),(Integer)vertIntermedios.get(i+1));
   for (int j=1; j<trayectoAuxiliar.size(); j++) 
    {
    int vertice=(Integer)trayectoAuxiliar.get(j);
    trayectoMinimoIntermedio.add(vertice);
    }
   }
  trayectoAuxiliar=trayectoMinimo((Integer)vertIntermedios.get(vertIntermedios.size()-1),destino);  // Trayecto mínimo desde el último intermedia al destino
  for (int k=1; k<trayectoAuxiliar.size(); k++) 
   {
   int vertice=(Integer)trayectoAuxiliar.get(k);
   trayectoMinimoIntermedio.add(vertice);
   }
  return trayectoMinimoIntermedio;
  }
 public ArrayList buscadorInteligente(int origen, int destino, int tiempo)
  {
  //***** buscadorInteligente() ***********************************************//
  //*** Recibiendo un tiempo máximo, un vértice origen y uno destino (o no) ***//
  //*** devuelve el trayecto mínimo entre origen y destino si entra dentro  ***//
  //*** de ese tiempo, o -1 si no (en el caso de que no halla estación des- ***//
  //*** tino devuelve todos los trayectos posibles entre origen y el resto  ***//
  //*** de estaciones que se adecúen al tiempo establecido, si no hay nin-  ***//
  //*** guna que cumpla los requisitos devuelve -1                          ***//
  //***************************************************************************//
  ArrayList listaTrayectosBuscador=new ArrayList();
  // CASO 1: VÉRTICE ORIGEN Y TIEMPO
  if (destino==9999)  // Si no hay vértice destino hay que comprobar todos los trayectos posibles
   {
   // CASO 1.1: VÉRTICE ORIGEN ES 0
   if (origen==0)  // Si no hay que transformar la matriz de adyacencia
    {
    boolean hayTrayectos=false;  // Nos dirá si al final del algoritmo hay trayectos en el tiempo pasado por parámetro o no
    ArrayList listaTrayectos=new ArrayList();  // Lista de todos los trayectos mínimos desde el vértice 0 al resto
    listaTrayectos=dijkstra(grafo);
    for (int i=0; i<listaTrayectos.size(); i++)  // Bucle para recorrer listaTrayectos
     {
     ArrayList trayecto=new ArrayList();
     trayecto=(ArrayList)listaTrayectos.get(i);  // Sacamos el trayecto que vamos a analizar
     int distancia=0;  // Distancia del trayecto
     for (int j=0; j<trayecto.size()-1; j++)  // Bucle para comparar las distancias del trayecto
      {
      distancia=distancia+grafo[(Integer)trayecto.get(j)][(Integer)trayecto.get(j+1)];   
      }
     if (distancia<tiempo)  // Si la distancia de este trayecto entra dentro del tiempo pasado por parámetro...
      {
      listaTrayectosBuscador.add(trayecto);  // ...añadimos el trayecto a los seleccionados
      hayTrayectos=true;  // Ponemos a true hayTrayectos
      }
     }
    if (!hayTrayectos)
     {
     listaTrayectosBuscador.add(-1);  // Si no hay trayectos devolvemos -1    
     }
    return listaTrayectosBuscador;
    }  // FIN CASO 1.1
   // CASO 1.2: VÉRTICE ORIGEN ES MAYOR QUE 0
   else  // if (origen!=0)  Si sí hay que transformar la matriz de adyacencia
    {
    boolean hayTrayectos=false;  // Nos dirá al final del algoritmo si hay trayectos dentro del tiempo pasado por parámetro
    ArrayList listaTrayectosTr=new ArrayList();  // Listas de trayectos
    ArrayList listaTrayectos=new ArrayList();
    int matrizTr[][];  // Matriz de adyacencia transformada
    matrizTr=transformarGrafo(origen);  // La inicializamos
    listaTrayectosTr=dijkstra(matrizTr);  // Aplicamos dijkstra sobre la matriz transformada
    listaTrayectos=detransformarLista(listaTrayectosTr,origen);  // Reconvertimos listaTrayectosTr a una lista correcta: listaTrayectos
    for (int i=0; i<listaTrayectos.size(); i++)  // Bucle para recorrer listaTrayectos
     {
     ArrayList trayecto=new ArrayList();
     trayecto=(ArrayList)listaTrayectos.get(i);  // Sacamos el trayecto que vamos a analizar
     int distancia=0;  // Distancia del trayecto
     for (int j=0; j<trayecto.size()-1; j++)  // Bucle para comparar las distancias del trayecto
      {
      distancia=distancia+grafo[(Integer)trayecto.get(j)][(Integer)trayecto.get(j+1)];   
      }
     if (distancia<tiempo)  // Si la distancia de este trayecto entra dentro del tiempo pasado por parámetro...
      {
      listaTrayectosBuscador.add(trayecto);  // ...añadimos el trayecto a los seleccionados
      hayTrayectos=true;  // Ponemos a true hayTrayectos
      }
     }
    if (!hayTrayectos)
     {
     listaTrayectosBuscador.add(-1);  // Si no hay trayectos devolvemos -1    
     }
    return listaTrayectosBuscador;
    }  // FIN CASO 1.2
   }  // FIN CASO 1
  // CASO 2: VÉRTICE ORIGEN, VÉRTICE DESTINO, Y TIEMPO
  else  // if (destino>=0)  Si hay vértice destino comprobamos un único trayecto
   {
   // CASO 2.1: VÉRTICE ORIGEN ES 0
   if (origen==0)  // Si no hay que transformar la matriz de adyacencia
    { 
    boolean encontrado=false;  // Indica si se ha encontrado trayecto al vértice pedido
    int i=0;
    ArrayList listaTrayectos=new ArrayList();  // Lista de trayectos mínimos desde el vértice 0 al resto
    listaTrayectos=dijkstra(grafo);
    while (!encontrado)  // Mientras no hallamos encontrado el trayecto al vértice pedido seguimos buscando
     {
     ArrayList trayecto=new ArrayList();
     trayecto=(ArrayList)listaTrayectos.get(i);  // Sacamos el trayecto 'i' de listaTrayectos
     if ((Integer)trayecto.get(trayecto.size()-1)==destino)  // Si el último vértice del trayecto 'i' es el destino...
      {
      encontrado=true;  // ...ya hemos encontrado trayecto, por lo que ponemos encontrado a true
      int distancia=0; 
      for (int j=0; j<trayecto.size()-1; j++)  // Bucle para conseguir la distancia del trayecto
       {
       distancia=distancia+grafo[(Integer)trayecto.get(j)][(Integer)trayecto.get(j+1)];   
       }
      if (distancia<tiempo)
       {
       listaTrayectosBuscador.add(trayecto);  // Si la distancia es menor que el tiempo pasado por parámetro devolvemos el trayecto
       }
      else 
       {
       listaTrayectosBuscador.add(-1);  // Si la distancia es mayor o igual que el tiempo pasado por parámetro devolvemos -1  
       }
      }
     i++;  
     }
    return listaTrayectosBuscador;
    }  // FIN CASO 2.1 
   // CASO 2.2: VÉRTICE ORIGEN ES MAYOR QUE 0
   else  // if (origen!=0)  Si sí hay que transformar la matriz de adyacencia
    {
    boolean encontrado=false;
    int i=0;
    ArrayList listaTrayectosTr=new ArrayList();  // Listas de trayectos
    ArrayList listaTrayectos=new ArrayList();
    int matrizTr[][];  // Matriz de adyacencia transformada
    matrizTr=transformarGrafo(origen);  // La inicializamos
    listaTrayectosTr=dijkstra(matrizTr);  // Aplicamos dijkstra sobre la matriz transformada
    listaTrayectos=detransformarLista(listaTrayectosTr,origen);  // Reconvertimos listaTrayectosTr a una lista correcta: listaTrayectos
    while (!encontrado)
     {
     ArrayList trayecto=new ArrayList();
     trayecto=(ArrayList)listaTrayectos.get(i);
     if ((Integer)trayecto.get(trayecto.size()-1)==destino)
      {
      encontrado=true;
      int distancia=0;
      for (int j=0; j<trayecto.size()-1; j++)  // Bucle para comparar las distancias del trayecto
       {
       distancia=distancia+grafo[(Integer)trayecto.get(j)][(Integer)trayecto.get(j+1)];   
       }
      if (distancia<tiempo)
       {
       listaTrayectosBuscador.add(trayecto);  // Si la distancia es menor que el tiempo pasado por parámetro devolvemos el trayecto
       }
      else 
       {
       listaTrayectosBuscador.add(-1);  // Si la distancia es mayor o igual que el tiempo pasado por parámetro devolvemos -1  
       }
      }
     i++;  
     }
    return listaTrayectosBuscador; 
    }  // FIN CASO 2.2
   }  // FIN CASO 2
  }
 }


