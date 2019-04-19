
学习GreenDao操作
===================
使用在Android Studio平台上  

GreenDao添加依赖：  
   
   1.修改工程的build.gradle文件，如下：  
    
    repositories {  
        google()  
        jcenter()  
        mavenCentral() // add repository  
    }  
    dependencies {  
        classpath 'com.android.tools.build:gradle:3.1.0'  
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1' // add plugin  

        // NOTE: Do not place your application dependencies here; they belong  
        // in the individual module build.gradle files  
    }  

   2.修改app目录下的build.gradle文件：  
    
    apply plugin: 'org.greenrobot.greendao' // apply plugin  
    添加依赖：  
    implementation 'org.greenrobot:greendao:3.2.2'  

踩过的坑：  
    1.主键类型为Long，不是long；  
    2.主键是自增的，写入数据时，主键参数 = null即可；
