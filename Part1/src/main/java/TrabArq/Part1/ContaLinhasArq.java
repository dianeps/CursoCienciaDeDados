package TrabArq.Part1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class ContaLinhasArq {
	public static void main(String[] args) {
		//configurando o Spark
		
		SparkConf conf = new SparkConf().setMaster("local").setAppName("DonoProcess");
		JavaSparkContext ctx = new JavaSparkContext(conf);
		
		//carregando os dados do txt file com os donos e os pets
		
		JavaRDD<String> donos = ctx.textFile("C:/Users/DIANEDESantos/Box Sync/All files/Mackenzie/2 - Arquitetura de Big data/Trabalho Individual/Donos_Pets.txt");
		long numeroLinhas = donos.count();
		
		//mostra o número de linhas que existem no arquivo
		System.out.println(numeroLinhas + " linhas nesse arquivo!");
		
		ctx.close();
	}
}
