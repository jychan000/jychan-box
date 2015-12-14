package com.jychan.box.machinelearning.bp;

/**
 * @author chenjinying
 * @version 15/12/12 11:32
 *          email:415683089@qq.com
 */
public class BpNetworkTest {

    /**
     * i = 1,2,...,n
     * j = 1,2,...,l
     * k = 1,2,...,m
     */

    private int nIn;      //输入层节点数量
    private int nHid;     //隐含层节点数量
    private int nOut;     //输出层节点数量

    private double[] qiWang;//期望输出

    private double[][] Wij;  //输入层到隐含层的权重Wij[i][j]
    private double[][] Wjk;  //隐含层到输出层的权重Wjk[j][k]

    private double[] a;      //输入层到隐含层的偏置
    private double[] b;      //隐含层到输出层的偏置

    private double rate;  //学习速率,初定0.1


    /**
     * 激励函数 g(x) is sigmoid function
     */
    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }


    /**
     * 误差计算
     * @param Y 期望输出
     * @param O 输出层输出
     * @return 误差期望
     */
    public double E(double[] Y, double[] O) {
        int n = O.length;
        double sum = 0;
        for (int k=0; k<n; k++) {
            sum += (Math.pow((Y[k] - O[k]), 2));
        }
        sum = sum / 2;
        return sum;
    }

    public double updateWij(double wij) {
        return 0;
    }
    public double updateWjk(double wjk ) {
        return 0;
    }








    /**
     * 初始化
     */
    private void init(int n, int l, int m) {

        //节点数量
        this.nIn = n;
        this.nHid = l;
        this.nOut = m;

        //权重
        Wij = new double[10][10];
        Wjk = new double[10][10];
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                Wij[i][j] = 1;
                Wjk[i][j] = 1;
            }
        }

        //偏离值
        a = new double[10];
        b = new double[10];
        for (int i=0; i<10; i++) {
            a[i] = 0;
            b[i] = 0;
        }

        //学习速率
        rate = 0.1;
    }

    /**
     * 隐含层的输出 Hj
     */
    public double oHidden(int j, double[] x) {
        int n = x.length;
        double sum = 0;
        for(int i=0; i<n; i++) {
            sum += (Wij[i][j] * x[i]);
        }
        sum += a[j];
        return sigmoid(sum);
    }

    /**
     * 输出层的输出
     * @param k 第k个输出节点
     * @param oHidden 隐含层全部节点的输出,数组
     * @return 输出层,第k个节点的最后输出
     */
    public double oOut(int k, double[] oHidden) {
        int n = oHidden.length;
        double sum = 0;
        for (int j=0; j<n; j++) {
            sum += (Wjk[j][k] * oHidden[j]);
        }
        sum += b[k];
        return sum;
    }

    /**
     * 计算出这次训练,全部输出节点的值
     * @param x 样本输入
     * @return 返回输出节点的值
     */
    public double[] trainingOneTime(double[] x) {

        //隐含层的输出
        double[] oHidden = new double[nHid];
        for (int j=0; j<nHid; j++) {
            oHidden[j] = oHidden(j, x);
        }

        //输出层的输出
        double[] oOut = new double[nOut];
        for (int k=0; k<nOut; k++) {
            oOut[k] = oOut(k, oHidden);
        }

        //误差计算


        return null;
    }

    /**
     * 训练样本1次
     * @param x 样本输入
     * @param oExpect 期望输出
     */
    public void training(double[] x, double[] oExpect) {
        double[] o = trainingOneTime(x);
        //x 输入
        //o 输出
        //oExpect 期望输出


    }

    public void start() {
        //1.初始化
        //2.


        //1.初始化
        init(3, 4, 3);

        //2.训练样本


        //

    }

    public static void main(String[] args) {
        //1.初始化
    }
}
