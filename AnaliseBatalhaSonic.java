import java.util.Scanner;

public class AnaliseBatalhaSonic {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        
        int esperanca = 0;
        int confianca = 0;
        int determinacao = 0;

       
        int medo = 0;
        int desanimo = 0;
        int incerteza = 0;

        
        
        System.out.println("--- FASE 1: Busca por Novos Aliados ---");
        System.out.print("Quantos novos aliados Sonic, Knuckles e Tails conseguiram encontrar para ajudar na luta contra Shadow? ");
        
        
        int numAliados = -1;
        while (numAliados < 0) {
            if (scanner.hasNextInt()) {
                numAliados = scanner.nextInt();
                if (numAliados < 0) {
                    System.out.print("Por favor, insira um número inteiro não negativo: ");
                }
            } else {
                System.out.print("Entrada inválida. Por favor, insira um número inteiro: ");
                scanner.next(); 
            }
        }
        
        if (numAliados > 0) {
            
            esperanca = numAliados * 15;
            System.out.println("-> Equipe encontrou " + numAliados + " aliados. Esperança aumentou em " + esperanca + " pontos.");
        } else {
            
            medo = 40;
            System.out.println("-> Equipe não encontrou novos aliados. Medo aumentou em 40 pontos.");
        }
        
        
        scanner.nextLine(); 

        
        
        System.out.println("\n--- FASE 2: Confrontos Iniciais Contra Shadow ---");
        int totalPontuacoes = 0;
        int numDesafios = 3;
        
        
        for (int i = 1; i <= numDesafios; i++) {
            int pontuacao = -1;
            while (pontuacao < 0 || pontuacao > 10) {
                System.out.print("Digite a pontuação do Desafio " + i + " (0 a 10): ");
                if (scanner.hasNextInt()) {
                    pontuacao = scanner.nextInt();
                    if (pontuacao < 0 || pontuacao > 10) {
                        System.out.print("Pontuação inválida. ");
                    }
                } else {
                    System.out.print("Entrada inválida. ");
                    scanner.next(); 
                }
            }
            totalPontuacoes += pontuacao;
        }

        
        double mediaDesafios = (double) totalPontuacoes / numDesafios;
        System.out.printf("-> Média dos 3 desafios: %.2f\n", mediaDesafios);

        
        if (mediaDesafios >= 7) {
            confianca = 60;
            System.out.println("-> Média >= 7. Confiança aumentou em 60 pontos.");
        } else {
            desanimo = 60;
            System.out.println("-> Média < 7. Desânimo aumentou em 60 pontos.");
        }

        
        scanner.nextLine(); 

        
        
        System.out.println("\n--- FASE 3: Análise de Estratégias ---");
        final int TOTAL_ESTRATEGIAS = 12;
        int estrategiasAnalisadas = -1;

        
        while (estrategiasAnalisadas < 0 || estrategiasAnalisadas > TOTAL_ESTRATEGIAS) {
            System.out.print("Das " + TOTAL_ESTRATEGIAS + " estratégias, quantas a equipe conseguiu analisar completamente? ");
            if (scanner.hasNextInt()) {
                estrategiasAnalisadas = scanner.nextInt();
                if (estrategiasAnalisadas < 0 || estrategiasAnalisadas > TOTAL_ESTRATEGIAS) {
                    System.out.print("Número inválido. ");
                }
            } else {
                System.out.print("Entrada inválida. ");
                scanner.next(); 
            }
        }
        
        
        int estrategiasNaoAnalisadas = TOTAL_ESTRATEGIAS - estrategiasAnalisadas;
        
        
        determinacao = estrategiasAnalisadas * 10;
        
        
        incerteza = estrategiasNaoAnalisadas * 10;

        System.out.println("-> Estratégias analisadas: " + estrategiasAnalisadas + ". Determinação aumentou em " + determinacao + " pontos.");
        System.out.println("-> Estratégias NÃO analisadas: " + estrategiasNaoAnalisadas + ". Incerteza aumentou em " + incerteza + " pontos.");
        
        scanner.close();

        
        
        System.out.println("\n=============================================");
        System.out.println("       ANÁLISE FINAL DE SENTIMENTOS        ");
        System.out.println("=============================================");

       
        System.out.println("\n--- Emoções Positivas ---");
        System.out.println("Esperança (Aliados):   " + esperanca + " pontos");
        System.out.println("Confiança (Desafios):  " + confianca + " pontos");
        System.out.println("Determinação (Análise):" + determinacao + " pontos");
        
        System.out.println("\n--- Emoções Negativas ---");
        System.out.println("Medo (Aliados):        " + medo + " pontos");
        System.out.println("Desânimo (Desafios):   " + desanimo + " pontos");
        System.out.println("Incerteza (Análise):   " + incerteza + " pontos");

        
        int totalPositivo = esperanca + confianca + determinacao;
        int totalNegativo = medo + desanimo + incerteza;

        System.out.println("\n---------------------------------------------");
        System.out.println("Total Emoções Positivas: " + totalPositivo + " pontos");
        System.out.println("Total Emoções Negativas: " + totalNegativo + " pontos");
        System.out.println("---------------------------------------------");

       
        System.out.println("\n--- VEREDITO FINAL ---");
        if (totalPositivo > totalNegativo) {
            System.out.println("O Shadow foi derrotado.");
        } else {
            System.out.println("O Shadow venceu o time do Sonic.");
        }
        System.out.println("=============================================");
    }
}