package com.jychan.box.machinelearning.bp;

import java.io.*;

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

    private double errorValueSuccess;//允许误差范围





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

        //允许误差范围
        errorValueSuccess = 0.0001;
    }

    /**
     * 激励函数 g(x) is sigmoid function
     */
    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
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
     * 误差计算
     * @param oOut 输出层输出
     * @param oExpect 期望输出
     * @return 误差值
     */
    public double errorCalculation(double[] oOut, double[] oExpect) {
        double errorValue = 0;
        for (int k=0; k<nOut; k++) {
            errorValue += (Math.pow((oExpect[k] - oOut[k]), 2));
        }
        errorValue = errorValue / 2;
        return errorValue;
    }

    /**
     * 更新网络
     */
    public void updateNetwork(double[] oHidden, double[] oOut, double[] oExpect) {
        double[] sumWEj = new double[nHid];

        //计算 SUM(Wjk * ek): k:1->nOut
        for (int j=0; j<nHid; j++) {
            double sumWETmp = 0;
            for (int k=0; k<nOut; k++) {
                sumWETmp += (Wjk[j][k] * (oExpect[k] - oOut[k]));
            }
            sumWEj[j] = sumWETmp;
        }

        // 更新网络权重 Wij
        for (int i=0; i<nIn; i++) {
            for (int j=0; j<nHid; j++) {
                Wij[i][j] += (rate * oHidden[j] * (1 - oHidden[j]) * sumWEj[j]);
            }
        }

        // 更新网络权重 Wjk
        for (int j=0; j<nHid; j++) {
            for (int k=0; k<nOut; k++) {
                Wjk[j][k] += (rate * oHidden[j] * (oExpect[k] - oOut[k]));
            }
        }

        // 更新偏置值a
        for (int j=0; j<nHid; j++) {
            a[j] += (rate * oHidden[j] * (1 - oHidden[j]) * sumWEj[j]);
        }

        // 更新偏置值b
        for (int k=0; k<nOut; k++) {
            b[k] += (rate * (oExpect[k] - oOut[k]));
        }
    }

    /**
     * 计算出这次训练,全部输出节点的值
     * @param x 样本输入
     * @param oExpect 样本期望输出
     * @return 本次输出的误差
     */
    public double trainingOne(double[] x, double[] oExpect) {

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

        //计算误差
        double errorValue = errorCalculation(oOut, oExpect);

        //更新网络
        if (errorValue > errorValueSuccess) {
            updateNetwork(oHidden, oOut, oExpect);
        }

        System.out.println(x[0] + "^2 " + " + " + x[1] + " = " + oOut[0] + "\t" + oExpect[0] + "\te=" + errorValue);
        return errorValue;
    }


    /**
     * 训练样本1次
     * @param x 样本输入
     * @param oExpect 期望输出
     */
    public double training(double[] x, double[] oExpect) {

//        int maxTime = 10;
//        while (maxTime > 0) {

            //计算网络输出层的输出
            double errorValue = trainingOne(x, oExpect);

//            if (errorValue <= errorValueSuccess) {
//                //误差达到可接受范围,停止训练
//                break;
//            }


//            maxTime--;
//        }
        return errorValue;

    }

    public void start() {

        String filePathIn = "/Users/Raymond/IdeaProjects/jychan-box/src/main/java/com/jychan/box/machinelearning/bp/data_fun_input";

        //1.初始化
        init(2, 4, 1);
        System.out.println("初始化完成");


        File file = new File(filePathIn);

        for(int p=0; p<1000; p++) {

            System.out.println("=========================================");
            try {
                BufferedReader in = new BufferedReader(new FileReader(file));
                String line = null;

                while ((line = in.readLine()) != null) {
                    String[] datas = line.split("   ");
                    if (datas.length == 0)
                        continue;

                    double[] dataInput = new double[datas.length];
                    double[] dataOutput = new double[1];

                    for (int i = 0; i < datas.length; i++) {
                        dataInput[i] = Double.parseDouble(datas[i]);
                    }

                    double output = dataInput[0] * dataInput[0] + dataInput[1];
                    dataOutput[0] = output;

                    //一次样本训练
                    training(dataInput, dataOutput);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        BpNetworkTest test = new BpNetworkTest();
        test.start();
    }
}
