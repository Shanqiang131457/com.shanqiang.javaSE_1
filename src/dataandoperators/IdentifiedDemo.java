package dataandoperators;
/**
 * 标识符规范：
 * 1，标识符必须以字母，下划线，或者美元符号
 * 2，其他部分必须是字母，下划线或者美元符号，但是不能出现特殊符号
 * 3，大小写敏感
 * 4，Java关键字不能使用或者保留字，留给系统使用的，表示特殊字符的含义
 *常规建议
 * 1，驼峰标识
 * 2，闻名知义
 * */
public class IdentifiedDemo {
    public static void main(String[] args) {
        int a=10;
        int _a=20;
        int $b=30;
        System.out.println(a);
        System.out.println(_a);
        System.out.println($b);
    }
}
