public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {8,0,3,2,7,7,7,3,7,2};
		int valor[]=new int [3];
		ImprimirTorres(a);
		System.out.println();
		valor=AreaMaxima(a);
		System.out.println();
		System.out.println("Posicion inicial: "+valor[0]);
		System.out.println("Posicion final: "+valor[1]);
		System.out.println("Posicion altura: "+valor[2]);
	}
	public static void ImprimirTorres(int a[]) {
		int max=0;
		for(int e=0;e<a.length;e++) {
			if(a[e]>max) {
				max=a[e];
			}
		}
		for(int h=0;h<max;h++) {
			for(int x=0;x<a.length;x++) {
				if(a[x]<max-h) {
					System.out.print("  ");
				}else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	public static int[] CrearResultado(int a[],int max[]) {
		int c[]=new int [a.length];
		for(int e=0;e<a.length;e++) {
			if(e>=max[0] && e<=max[1]) {				
				c[e]=max[2];
			}
		}
		return c;
	}
	public static int[] AreaMaxima(int a[]) {
		int arreglo[]=new int[3];
		//[inicio,fin,altura]
		int area[]=new int[a.length];
		int area1=0;
		int max=0;
		for(int e=0;e<a.length;e++) {
			if(a[e]>max) {
				max=a[e];
				arreglo[0]=e;
				arreglo[1]=e;
				arreglo[2]=a[e];
			}
		}
		area1=max;
		int hmin=0;
		for(int l=2;l<a.length;l++) {
			for(int e=0;e<a.length+1-l;e++) {
				hmin=a[e];
				for(int b=1;b<l;b++) {
					if(hmin>a[e+b]) {
						hmin=a[e+b];
					}
				}
				max=hmin*l;
				if(max>area1) {
					area1=max;
					arreglo[0]=e;
					arreglo[1]=e+l-1;
					arreglo[2]=hmin;
				}
			}
		}		
		area=CrearResultado(a,arreglo);
		ImprimirTorres(area);
	return 	arreglo;
	}
}
