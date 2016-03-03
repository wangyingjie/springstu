//package com.jd.treasureshop.web.com.jd.proxyaop;
//
///**
// * Created by wangyingjie1 on 2016/3/3.
// */
//import com.jd.treasureshop.web.com.jd.proxyaop.IUserService;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//public final class Proxy11 extends Proxy
//        implements IUserService
//{
//    private static Method m3;
//    private static Method m1;
//    private static Method m0;
//    private static Method m2;
//
//    public Proxy11()
//            throws
//    {
//        super(paramInvocationHandler);
//    }
//

      //该方法属于代理类接口的方法
//    public final void sayHello()
//            throws
//    {
//        try
//        {
               // 实际上就是调用MyInvocationHandler的public Object invoke(Object proxy, Method method, Object[] args)方法，第二个问题就解决了
              // 动态代理的关键代码，此处才是调用代理对象的  invoke 方法的地方
//            this.h.invoke(this, m3, null);


//            return;
//        }
//        catch (RuntimeException localRuntimeException)
//        {
//            throw localRuntimeException;
//        }
//        catch (Throwable localThrowable)
//        {
//            throw new UndeclaredThrowableException(localThrowable);
//        }
//    }
//
//    public final boolean equals()
//            throws
//    {
//        try
//        {
//            return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
//        }
//        catch (RuntimeException localRuntimeException)
//        {
//            throw localRuntimeException;
//        }
//        catch (Throwable localThrowable)
//        {
//            throw new UndeclaredThrowableException(localThrowable);
//        }
//    }
//
//    public final int hashCode()
//            throws
//    {
//        try
//        {
//            return ((Integer)this.h.invoke(this, m0, null)).intValue();
//        }
//        catch (RuntimeException localRuntimeException)
//        {
//            throw localRuntimeException;
//        }
//        catch (Throwable localThrowable)
//        {
//            throw new UndeclaredThrowableException(localThrowable);
//        }
//    }
//
//    public final String toString()
//            throws
//    {
//        try
//        {
//            return ((String)this.h.invoke(this, m2, null));
//        }
//        catch (RuntimeException localRuntimeException)
//        {
//            throw localRuntimeException;
//        }
//        catch (Throwable localThrowable)
//        {
//            throw new UndeclaredThrowableException(localThrowable);
//        }
//    }
//
//    static
//    {
//        try
//        {
//            在静态代码块中获取了4个方法：Object中的equals方法、UserService中的add方法、Object中的hashCode方法、Object中toString方法

//            m3 = Class.forName("com.jd.treasureshop.web.com.jd.proxyaop.IUserService").getMethod("sayHello", new Class[0]);
//            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
//            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
//            return;
//        }
//        catch (NoSuchMethodException localNoSuchMethodException)
//        {
//            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
//        }
//        catch (ClassNotFoundException localClassNotFoundException)
//        {
//            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
//        }
//    }
//}