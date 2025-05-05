public class Distancemeter implements Distance {
    public String euclidean(double[] a, double[] b, double[] c) {
        double dAB = this.calcEuclidean(a, b);
        double dAC = this.calcEuclidean(a, c);
        double dBC = this.calcEuclidean(b, c);

        double[] dists = {dAB, dAC, dBC};

        return this.compareDistances(dists, "Euclidiana");
    }

    private double calcEuclidean(double[] e1, double[] e2) {
        double sum = 0;
            for (int i = 0; i < e1.length; i++) {
                sum += Math.pow(e1[i] - e2[i], 2);
            }
        return Math.sqrt(sum);
    }

    public String cityBlock(double[] a, double[] b, double[] c) {
        double dAB = this.calcCityBlock(a, b);
        double dAC = this.calcCityBlock(a, c);
        double dBC = this.calcCityBlock(b, c);

        double[] dists = {dAB, dAC, dBC};

        return this.compareDistances(dists, "City Block");
    }
    
    public double calcCityBlock(double[] e1, double[] e2) {
        double sum = 0;
        for (int i = 0; i < e1.length; i++) {
            sum += Math.abs(e1[i] - e2[i]);
        }
        return sum;
    }

    private String compareDistances(double[] dists, String method) {
        String[] pairs = {"A-B", "A-C", "B-C"};

        double minValue = dists[0];
        int index = 0;
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] < minValue) {
                minValue = dists[i];
                index = i;
            }
        }

        String msg = "\n---------------------------------------------------\n\n";
        msg = msg + " A distância "+ method + " dos pontos é:\n";
        msg = msg + "\tA-B: " + Double.toString(dists[0]) + " mm\n";
        msg = msg + "\tA-C: " + Double.toString(dists[1]) + " mm\n";
        msg = msg + "\tB-C: " + Double.toString(dists[2]) + " mm\n";
        msg = msg + "\n O par " + pairs[index] + " compõe os mais similares dos analisados";
        msg = msg + "\n\n---------------------------------------------------\n";

        return msg;
    }
}

