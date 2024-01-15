class Test {
    private String fieldName;
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public static void staticMethod() {
        System.out.println("静态方法");
    }

    public Test() {
        System.out.println("无参构造函数");
    }

    public Test(String fieldName) {
        System.out.println("有参构造函数");
        this.fieldName = fieldName;
    }

}

void main() throws Exception{
    System.out.println("当前类名: "+ this.getClass().getName());
    System.out.println("================");

    System.out.println("调用无参构造函数");
    System.out.println("<======结果=====");
    var test1 = new Test();
    System.out.println("===============>");

    System.out.println("调用有参构造函数");
    System.out.println("<======结果=====");
    var test2 = new Test("Hi");
    System.out.println("===============>");

    System.out.println("调用静态方法");
    System.out.println("<======结果=====");
    Test.staticMethod();
    System.out.println("===============>");

    System.out.println("使用.class");
    System.out.println("<======结果=====");
    var clz1 = Test.class;
    System.out.println("===============>");

    System.out.println("使用Class.forName");
    System.out.println("<======结果=====");
    var clz2 = Class.forName("ExploreClassLoad$Test");
    System.out.println("===============>");

    System.out.println("使用Class.forName并使用newInstance");
    System.out.println("<======结果=====");
    var clz3 = Class.forName("ExploreClassLoad$Test");
    var test3 = clz3.getDeclaredConstructor(this.getClass()).newInstance(this.getClass().newInstance());
    System.out.println("===============>");
}