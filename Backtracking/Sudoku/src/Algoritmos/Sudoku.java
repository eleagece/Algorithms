package Algoritmos;
import java.util.Random;
public class Sudoku implements Cloneable 
 {
 private boolean duplicados=false;  // Nos indica si el sudoku metido por constructor lo hemos hecho con n�meros duplicados
 private int sudoku[][]=new int[9][9];  // sudoku[1][2]==5 significa que en la posicion 1,2 hay un 5
 private boolean filasB[][]=new boolean[9][9];  // fila[1][5]==true significa que en la fila 1 ya existe un 5
 private boolean columnasB[][]=new boolean[9][9];  // columna[2][5]==true significa que en la columna 2 ya existe un 5
 private boolean cuadradosB[][]=new boolean[9][9];  // cuadrado[0][5]==true significa que en el cuadrado 0 ya existe un 5
 public Sudoku() 
  {
  }
 public Sudoku(int matrizSudoku[][])
  {
  //***** Sudoku() ************************************************************//
  //*** Constructor parametrizado, actualiza las matrices de booleanos des- ***//
  //*** pu�s de recibir el nuevo sudoku.                                    ***//
  //***************************************************************************//
  copiar2(matrizSudoku);
  actualizarB();
  }
 public int[][] dameMatrizSudoku()
  {
  //***** dameSudoku() ********************************************************//
  //*** Getter que devuelve la matriz del sudoku.                           ***//
  //***************************************************************************//
  return sudoku;   
  }
 public void imprimirSudoku()
  {
  //***** imprimir() **********************************************************//
  //*** Imprime por consola el sudoku                                       ***//
  //***************************************************************************//
  System.out.println("� - - - � - - - � - - - �");
  for (int f=0; f<9; f++)
   {
   if (f==3 || f==6)
    {
    System.out.print("� - - - � - - - � - - - �");
    System.out.println();
    }
   for (int c=0; c<9; c++)
    {
    if (c==0)
     {
     System.out.print("| ");
     if (sudoku[f][c]==0)
      {
      System.out.print("# ");   
      }
     else
      {
      System.out.print(sudoku[f][c]+" ");
      }
     }
    else if (c==2 || c==5)
     {
     if (sudoku[f][c]==0)
      {
      System.out.print("#");   
      }
     else
      {
      System.out.print(sudoku[f][c]);
      }
     System.out.print(" | ");
     }
    else if (c==8)
     {
     if (sudoku[f][c]==0)
      {
      System.out.print("#");   
      }
     else
      {
      System.out.print(sudoku[f][c]);
      }
     System.out.print(" |");
     }
    else
     {
     if (sudoku[f][c]==0)
      {
      System.out.print("#");   
      }
     else
      {
      System.out.print(sudoku[f][c]);
      }
     System.out.print(" ");        
     }
    }
   System.out.println();  // Un salto de linea por cada fila escrita
   }
  System.out.println("� - - - � - - - � - - - �");
  }
 public int[] generarSudoku(int numCasillas)  // Intenta generar un sudoku de 'numCasillas' casillas. Puede que lo consiga o no
  {
  //***** generaSudoku() ******************************************************//
  //*** Intenta generar un sudoku de 'n' posiciones rellenas. Puede que no  ***//
  //*** lo consiga. Si lo consigue no significa que el sudoku tenga solu-   ***//
  //*** ci�n. Eso hay que verificarlo a posteriori.                         ***//
  //*** Devuelve un array de tres posiciones. En la primera devuelve el n�- ***//
  //*** mero de elementos generados. En la segunda y terecera, la posici�n  ***//
  //*** de la casilla (fila y columna) que no se pudo rellenar, si es que   ***//
  //*** efectivamente no se pudo.                                           ***//
  //***************************************************************************//  
  int dev[]=new int[3];
  inicializarSudoku();  // Inicializa el sudoku todo a 0's
  inicializarB();  // Inicializa las matrices de booleanos todas a false
  int i=0;
  for (i=0; i<numCasillas; i++)  // Un bucle para rellenar las casillas pedidas
   {
   Random generator=new Random();
   boolean vacia=false;
   int f=0;
   int c=0;
   // GENERACI�N DE CASILLA VAC�A
   while (!vacia)  // While que busca una casilla vac�a
    {
    f=generator.nextInt(9);  // N�mero aleatorio, de 0 a 8
    c=generator.nextInt(9);
    vacia=esVacia(f,c);
    }  // Una vez sale del while, lo siguiente es rellenar la casilla correspondiente a [f][c]
   // GENERACI�N DE ELEMENTO PARA LA CASILLA VAC�A
   int cont=0;
   boolean rellenada=false;
   boolean listaPretFallidos[]=new boolean[9];  // array que marca con true los pretendientes que no se pueden poner en la casilla           
   while (!rellenada && cont<9)  // While que rellena la casilla vac�a. Se puede salir porque la ha rellenado, o porque es imposible rellenarla
    {
    int pretendiente=generator.nextInt(9);  // Genera un n�mero para la casilla
    int q=obtenerCuadrado(f,c);
    if (pretendienteApto(f,c,q,pretendiente))  // Si es apto para poner (no est� ya en la fila, columna o cuadrado correspondiente)
     {
     sudoku[f][c]=pretendiente+1;  // Pone el pretendiente en la casilla
     marcarB(f,c,q,pretendiente);  // Actualiza las matrices de booleanos
     rellenada=true;  // Y dice que est� rellenada para salir del while
     }
    else if (listaPretFallidos[pretendiente]==false)  // Si no es apto y siempre que no lo hubi�ramos comprobado antes
     {
     listaPretFallidos[pretendiente]=true;  // Lo ponemos en la lista de pretendientes fallidos
     cont++;  // Y aumentamos el contador. Si en alg�n momento llega a 9, ser� que no hay nadie apto para esa casilla y nos saldremos del while
     }
    }
   if (cont==9)  // Si sale del while porque llenamos el contador, significa que no hay pretendiente posible para esa casilla. 
    {            // As� que hacemos un return de error indicando los elementos llenados y la posici�n que no se pod�a llenar.
    dev[0]=i;  // Elementos llenados
    dev[1]=f;  // Fila
    dev[2]=c;  // Columna
    return dev;
    }
   }
  dev[0]=i;
  return dev;
  }
 public int generarSudokuEntero(int numCasillas)  // Genera un sudoku de 'numCasillas' casillas. Puede tener o no soluci�n
  {
  //***** generaSudokuEntero() ************************************************//
  //*** Genera un sudoku con 'n' posiciones rellenas, usando para ello el   ***//
  //*** m�todo 'generaSudoku' original. Para valores de 'n' menores o igua- ***//
  //*** les que 65 la creaci�n del sudoku es bastante r�pida. Sin embargo,  ***//
  //*** a partir de 65 elementos se hace un trabajo mucho m�s lento, lle-   ***//
  //*** gando incluso a no terminar.                                        ***//
  //*** Como ejemplo, generar un sudoku con 70 posiciones rellenas ha tar-  ***//
  //*** dado en una ocasi�n 1 minuto y 25 segundos.                         ***//
  //*** Devuelve un entero con el n�mero de casillas generadas para confir- ***//
  //*** mar que realmente las ha rellenado.                                 ***//
  //***************************************************************************//  
  int numCasillasRellenas=0;
  int dev[]=new int[3];
  while (numCasillas!=numCasillasRellenas)
   {
   dev=generarSudoku(numCasillas);
   numCasillasRellenas=dev[0];
   }
  return dev[0];
  }
 public boolean resolverSudoku(int f, int c)  // Resuelve un sudoku (empezando en f=0, c=0). Si devuelve false no tiene soluci�n.
  {
  //***** resolverSudoku() ****************************************************//
  //*** M�todo que trata de buscar soluci�n a un sudoku. Puede que la en-   ***//
  //*** cuentre o puede que no. Si resuelve el sudoku devuelve true. Si no, ***//
  //*** devuelve false y en 'f' y 'c' la posici�n del error.                ***//
  //***************************************************************************//
  boolean vueltaAtras=false;  // variable que nos indica que hay que volver a atr�s para estudiar otras posibles soluciones para una casilla
  boolean resuelto=false;  // variable que se propaga hasta la primera llamada para indicar que el sudoku se ha resuelto
  if (esVacia(f,c))  // Si la posici�n est� vac�a
   {
   int pretendiente=0;
   for (pretendiente=0; pretendiente<9; pretendiente++)  // Busca un pretendiente
    {
    int qAct=obtenerCuadrado(f,c);
    if (pretendienteApto(f,c,qAct,pretendiente))  // Si el pretendiente es apto
     {
     sudoku[f][c]=pretendiente+1;  // Lo ponemos en la matriz correspondiente al sudoku y...
     marcarB(f,c,qAct,pretendiente);  // ...actualizamos las matrices de booleanos
     if (c<8)  // Si no hemos llegado a la �ltima columna... 
      { 
      resuelto=resolverSudoku(f,c+1);  // ...llamamos a resolverSudoku con la columna siguiente en la misma fila
      if (resuelto)  // Si esa llamada nos devuelve true el sudoku est� resuelto... 
       {
       return true;  // ...as� que seguimos propagando la informaci�n hacia arriba hasta la primera llamada 
       }
      vueltaAtras=true;  // Si esa llamada nos devuelve false el sudoku no est� resuelto y hay que buscar otras soluciones 
      }
     else if (f<8)  // Si hemos llegado a la �ltima columna, pero no hemos llegado a la �ltima fila... 
      { 
      resuelto=resolverSudoku(f+1,0);  // ...llamamos a resolverSudoku con la fila siguiente y la columna 0
      if (resuelto)  // Si esa llamada nos devuelve true el sudoku est� resuelto...
       {
       return true;  // ...as� que seguimos propagando la informaci�n hacia arriba hasta la primera llamada
       }
      vueltaAtras=true;  // Si esa llamada nos devuelve false el sudoku no est� resuelto y hay que buscar otras soluciones  
      }
     else if (f==8)  // Si hemos llegado a la �ltima casilla... 
      {
      return true;  // ...propagamos la informaci�n hacia arriba de que se acaba de resolver el sudoku 
      }
     }
    if (vueltaAtras)  // Si la llamada nos devolvi� fals el sudoku no est� resuelto as� que tenemos que buscar otra soluci�n... 
     { 
     desmarcarB(f,c,qAct,pretendiente);  // ...quitando la que hab�amos probado para seguir con otras 
     sudoku[f][c]=0; 
     }
    vueltaAtras=false;  // Importante poner vueltaAtras a false para que no vuelva a desmarcar una vez encontremos una nueva soluci�n
    }
   if (pretendiente==9)  // Si no hay ninguna soluci�n para esa casilla propagamos false hacia arriba 
    { 
    return false; 
    }
   }
  else  // Si la posici�n no est� vac�a simplemente seguimos procesando
   {
   if (c<8) 
    { 
    resuelto=resolverSudoku(f,c+1); 
    if (resuelto) 
     {
     return true; 
     }
    vueltaAtras=true; 
    }
   else if (f<8) 
    { 
    resuelto=resolverSudoku(f+1,0); 
    if (resuelto)
     {
     return true;
     }
    vueltaAtras=true; 
    }
   else if (f==8) 
    {
    return true; 
    }
   }
  return false;
  }
 public void resolverSudokuEntero(int numCasillas)  // Resuelve un sudoku de 'numCasillas' y lo muestra por consola
  {
  //***** resolverSudokuEntero() **********************************************//
  //*** Es un m�todo que resuelve un sudoku de 'numCasillas' posiciones re- ***//
  //*** llenas al inicio. Para ello tiene que primero generar un sudoku de  ***//
  //*** 'numCasillas' posiciones y luego intentar resolverlo. Si no lo con- ***//
  //*** sigue repite el proceso hasta que lo hace o hasta que lo intenta    ***//
  //*** 'intentos' veces infructuosamente.                                  ***//
  //*** Por pantalla muestra el sudoku resuelto o un mensaje de error seg�n ***//
  //*** halla o no conseguido su prop�sito.                                 ***//
  //*** El problema para resolver el sudoku es exponencial. En la pr�ctica, ***//
  //*** esto significa que hasta 40 elementos construir sudokus y resolver- ***//
  //*** los es relativamente f�cil. Pero a partir de ah� los tiempos se ha- ***//
  //*** cen inc�modos, llegando a ser intratables para unos 50 elementos.   ***//
  //***************************************************************************//
  boolean resuelto=false;
  int cont=0;
  int intentos=200000;
  while (!resuelto && cont<intentos)  // Genera un sudoku de 'numCasillas' y lo resuelve. Hace 'intentos' intentos.
   {
   cont++;
   generarSudokuEntero(numCasillas);
   System.out.println("Intento n�mero "+cont);
   imprimirSudoku();  // Imprime el sudoku sin resolver
   if (resolverSudoku(0,0))  // Trata de resolver el sudoku
    {
    resuelto=true;
    }   
   }
  if (resuelto)  // Si sale porque lo resolvi� lo imprime
   {
   System.out.println("Sudoku resuelto en intento n�mero "+cont);
   imprimirSudoku();
   }
  else  // Si sali� por completar los intentos lo indica por pantalla
   {
   System.out.println("Imposible hallar sudoku tras "+cont+" intentos");   
   }
  }
 public boolean resolverSudokuAleatorio(int numCasillas, int[][] matrizSudokuSinResolver)
  {
  boolean resuelto=false;
  int cont=0;
  int intentos=200000;
  while (!resuelto && cont<intentos)  // Genera un sudoku de 'numCasillas' y lo resuelve. Hace 'intentos' intentos.
   {
   cont++;
   generarSudokuEntero(numCasillas);
   copiar(matrizSudokuSinResolver);  // Copia sudoku (local) en matrizSudokuSinResolver (par�metro)
   resuelto=resolverSudoku(0,0);
   }
  return resuelto;
  }
 private void inicializarB()
  {
  //***** inicializarB() ******************************************************//
  //*** Inicializa las matrices de booleanos con todo a false               ***//
  //***************************************************************************//  
  for (int f=0; f<9; f++)
   {
   for (int c=0; c<9; c++)
    {
    filasB[f][c]=false;
    columnasB[f][c]=false;
    cuadradosB[f][c]=false;
    }
   }
  }
 private void inicializarSudoku()
  {
  //***** inicializarSudoku() *************************************************//
  //*** Inicializa la matriz del sudoku dej�ndola vac�a (todo 0's)          ***//
  //***************************************************************************//  
  for (int f=0; f<9; f++)
   {
   for (int c=0; c<9; c++)
    {
    sudoku[f][c]=0;
    }
   }    
  }
 private void actualizarB()
  {
  for (int f=0; f<9; f++)
   for (int c=0; c<9; c++)
    {
    if (!esVacia(f,c))
     {
     int qAct=obtenerCuadrado(f,c);
     int valor=sudoku[f][c]-1;
     if (valorEstaYa(valor,f,c,qAct))
      duplicados=true;
     marcarB(f,c,qAct,valor);
     }
    }
  }
 public boolean esVacia(int f, int c)
  {
  //***** esVacia() ***********************************************************//
  //*** Devuelve true si las coordenadas pasadas por par�metro son las de   ***//
  //*** una casilla vac�a (contiene un 0). Devuelve false en otro caso.     ***//
  //***************************************************************************//
  if (sudoku[f][c]==0)
   {
   return true;   
   }
  else
   {
   return false;   
   }
  }
 private int obtenerCuadrado(int f, int c)
  {
  //***** obtenerCuadrado() ***************************************************//
  //*** Teniendo las coordenadas de una casilla devuelve el cuadrado en que ***//
  //*** que se encuentran esas coordenadas.                                 ***//
  //***************************************************************************//
  int fQ=f/3;
  int cQ=c/3;
  if (fQ==0)
   {
   switch (cQ)
    {
    case 0: return 0;
    case 1: return 1;
    case 2: return 2;
    }
   }
  else if (fQ==1)
   {
   switch (cQ)
    {
    case 0: return 3;
    case 1: return 4;
    case 2: return 5;
    }
   }
  else if (fQ==2)
   {
   switch (cQ)
    {
    case 0: return 6;
    case 1: return 7;
    case 2: return 8;
    }
   }
  return 0;  // Return in�til, hay que ponerlo para que NetBeans no se queje
  }
 private boolean pretendienteApto(int f, int c, int q, int pretendiente)
  {
  //***** pretendienteApto() **************************************************//
  //*** Comprueba que 'pretendiente' es apto. Es decir, que no est� en la   ***//
  //*** fila 'f', columna 'c' o cuadrado 'q'. Eso se sabe recurriendo a las ***//
  //*** matrices de booleanos.                                              ***//
  //***************************************************************************//
  boolean aptoFila=filasB[f][pretendiente]==false;  // aptoFila si en la matriz de filas, en la fila 'f', 'pretendiente' es false
  boolean aptoColumna=columnasB[c][pretendiente]==false;  // aptoColumna si en la matriz de columnas, en la columna 'c', 'pretendiente' es false
  boolean aptoCuadrado=cuadradosB[q][pretendiente]==false;  // aptoCuadrado si en la matriz de cuadrados, en el cuadrado 'q', 'pretendiente' es false
  return aptoFila && aptoColumna && aptoCuadrado;  // 'pretendiente' es apto cuando no est� en 'f', 'c' y 'q'
  }
 private void marcarB(int f, int c, int q, int valor)
  {
  //***** marcarB() ***********************************************************//
  //*** Actualiza las matrices de booleanos, haciendo que el valor pasado   ***//
  //*** por par�metro sea visto como usado.                                 ***//
  //***************************************************************************//
  filasB[f][valor]=true;
  columnasB[c][valor]=true;
  cuadradosB[q][valor]=true;
  }
 private void desmarcarB(int f, int c, int q, int valor)
  {
  //***** desmarcarB() ********************************************************//
  //*** Actualiza las matrices de booleanos, haciendo que el valor pasado   ***//
  //*** por par�metro sea visto como no usado.                              ***//
  //***************************************************************************//
  filasB[f][valor]=false;
  columnasB[c][valor]=false;
  cuadradosB[q][valor]=false;     
  }
 public boolean esMatrizIncorrecta() 
  {
  //***** esMatrizIncorrecta() ************************************************//
  //*** Devuelve true cuando hay duplicados, es decir, si tenemos un n�mero ***//
  //*** repetido en la misma fila, columna o cuadrado.                      ***//
  //***************************************************************************//
  return duplicados;
  }
 private boolean valorEstaYa(int valor, int f, int c, int q) 
  {
  //***** valorEstaYa() *******************************************************//
  //*** Se encarga de comprobar, al actualizar las matrices de booleanos si ***//
  //*** hay alg�n elemento duplicado. En ese caso devuelve true.            ***//
  //***************************************************************************//  
  if (filasB[f][valor]==true ||
      columnasB[c][valor]==true ||
      cuadradosB[q][valor]==true)
   return true;
  else
   return false;
  }
 private void copiar(int[][] matrizSudokuSinResolver) 
  {
  for (int f=0; f<9; f++)
   for (int c=0; c<9; c++)
    {
    matrizSudokuSinResolver[f][c]=sudoku[f][c];  
    }
  }
 private void copiar2(int[][] matrizSudokuEntrada) 
  {
  for (int f=0; f<9; f++)
   for (int c=0; c<9; c++)
    {
    sudoku[f][c]=matrizSudokuEntrada[f][c];  
    }
  }
 }