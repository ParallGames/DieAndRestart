-injars      build/release/DAR.jar
-outjars     build/release/OptiDAR.jar

-libraryjars <java.home>/lib/rt.jar
-libraryjars <java.home>/lib/ext/jfxrt.jar


-optimizationpasses 1000 
-overloadaggressively 
-repackageclasses ''
-allowaccessmodification

-keepclasseswithmembers public class * { 
    public static void main(java.lang.String[]); 
}
