package com.imooc.zhangxiaoxi.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "G:\\work2019\\repo\\996\\src\\test\\java\\com\\imooc\\zhangxiaoxi\\lambda\\file\\FileServiceTest.java";

        // 通过lambda表达式，打印文件内容
        fileService.fileHandle(filePath,
                System.out::println);

        fileService.fileHandle(filePath, str -> System.out.println(str));
    }
}
