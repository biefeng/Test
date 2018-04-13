package com.biefeng.demo.aop;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AopMethodVisitor extends MethodVisitor implements Opcodes{
    public AopMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, "com/biefeng/demo/aop/AopInterceptor", "before", "()V", false);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= IRETURN && opcode <= RETURN)// 在返回之前安插after 代码。
            this.visitMethodInsn(INVOKESTATIC, "com/biefeng/demo/aop/AopInterceptor", "after", "()V", false);
        super.visitInsn(opcode);
    }
}
