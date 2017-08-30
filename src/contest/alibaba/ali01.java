package contest.alibaba;

import java.util.*;

/**
 *
     1.天猫国际每天都会卖出很多跨境商品，用户每次下单可能购买多个商品，购买总数小于10件，由于海关规定，每一个进入海关的箱子里面的商品总
     额不能超过2000元（否则不能清关）所以当用户下单总金额超过2000，必须使用多个箱子分开包装运输；现在为了节约运输成本，希望在满足海关
     的要求下，能够使用尽可能少的箱子。
     注：
     每个商品都有自己的单价，有特定的长宽高，所有商品都是长方体
     商品可以横放、竖放、侧放，但不用考虑斜放，但是长宽高各项总和必须都要小于等于箱子的长宽高
     假定目前天猫国际使用同一种规格的箱子
     boxLong,boxWidth,boxHigh
     （箱子长，箱子宽，箱子高）
     某用户下单买了如下商品
     n（商品件数）
     item1Price,item1Long,item1With,item1High
     item2Price,item2Long,item2With,item2High
     item3Price,item3Long,item3With,item3High
     item4Price,item4Long,item4With,item4High
     ...
     （商品价格，商品长，商品宽，商品高）
     (所有输入类型均为int型正整数)
     请你算出需要使用最小的箱子数量，可以将这些商品顺利得清关送到消费者手中，如果无解，输出-1

     输入范例:
     10 20 30
     3
     1000 10 10 30
     500 10 10 20
     600 8 10 20
     输出范例:
     2
 */
public class ali01 {

    static Model boxTemplate = new Model();
    static Model[] items;
    static int boxMinNum;
    /*
    private static double calcValue(Model m) {
        return (calcVolume(m) * 1.0) / m.price;
    }*/
    //体积排序

    private static int calcVolume(Model m) {
        return m.height * m.length * m.width;
    }


    private static int process() {

        int[] size = switch2Len(boxTemplate);

        int sumPrice = 0;
        List<Model> itemsList = new LinkedList<>();
        for (int i = 0; i < items.length; i++) {
            itemsList.add(items[i]);
        }
        //降序
        itemsList.sort(new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                return calcVolume(o2) - calcVolume(o1);
            }
        });

        Model restModel = new Model();
        restModel.length = size[2];
        restModel.width = size[1];
        restModel.height = size[0];
        PriorityQueue<Model> priorityQueue = new PriorityQueue<>(new VolumnComparator());
        priorityQueue.offer(restModel);
        int i = 0;
        while(itemsList.size() > 0){
            //剩余箱子装不下任何一件物品，则添加一个
            if(i == itemsList.size()){
                boxMinNum ++;
                //重置剩余空间队列
                priorityQueue.clear();
                priorityQueue.offer(restModel);
            }
            Model model = itemsList.get(i);
            if(sumPrice  + model.price >= boxTemplate.price){
                boxMinNum ++;
                //重置剩余空间队列
                priorityQueue.clear();
                priorityQueue.offer(restModel);
            }

            Model spaceModel = priorityQueue.poll();
            //判断是否能放下,不能则去装下一个箱子
            if(!isCanContain(model,spaceModel)){
                i++;
                continue;
            }
            //将切后空间放回队列待使用
            for(Model m :fileAndCutModel(model,spaceModel)){
                priorityQueue.offer(m);
            }
            //装下，则去掉该物品
            itemsList.remove(model);
            sumPrice += model.price;
        }

        return boxMinNum;
    }
    //判断是否可以放下
    private static boolean isCanContain(Model item, Model space) {
        int[] itemLen = switch2Len(item);
        int[] spaceLen =switch2Len(space);
        for(int i = 0; i < 3; i++){
            if(spaceLen[i] < itemLen[i]) return false;
        }
        return true;
    }

    //存放物品，并对剩余箱子空间进行切分,存放一个物品至多可以出现三个切空间
    static List<Model> fileAndCutModel(Model item, Model space){
        int[] itemLen = switch2Len(item);
        int[] spaceLen =switch2Len(space);

        List<Model> restModels = new LinkedList<>();

        Model model1 = new Model();
        model1.length = spaceLen[3];
        model1.width = spaceLen[2]- itemLen[2];
        model1.height = spaceLen[1];
        restModels.add(model1);

        Model model2 = new Model();
        model2.length = spaceLen[3] - itemLen[3];
        model2.width = spaceLen[2]- itemLen[2];
        model2.height = spaceLen[1];
        restModels.add(model2);


        Model model3 = new Model();
        model3.length = spaceLen[3] - itemLen[3];
        model3.width = spaceLen[2]- itemLen[2];
        model3.height = spaceLen[1] - spaceLen[1];
        restModels.add(model3);

        return restModels;
    }

    //长宽高排序
    static int[] switch2Len(Model item){
        int[] result = new int[3];
        result[0] = item.height;
        result[1] = item.width;
        result[2] = item.length;
        Arrays.sort(result);
        return result;
    }


    static class VolumnComparator implements Comparator<Model> {
        @Override
        public int compare(Model o1, Model o2) {
            return calcVolume(o2) - calcVolume(o1);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        boxTemplate.price = 2000;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());
        }
    }
}

class Model {
    public int price;
    public int length;
    public int width;
    public int height;
}


