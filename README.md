Android Custom Toggle Buttons,TextView
=============================


togglebutton 目前有切换动画效果, textview 有类似支付宝数字变化效果。
包含了checkstyle，pmd，findbugs的代码风格校验，使用gradle编译，如果用jenkins构建项目，可以增加配置，在构建后将检验结果发送到相应RD邮箱。

The toggle button will consist of a black oval containing a circle. The circle's position represents the current setting: left for "off", right for "on". When the toggle button is pressed, the circle will move to the right and the containing oval will animate to green.

BONUS: this control is directly tied to Android's SharedPreferences, so your setting will persist to the device

!["Custom View"](https://github.com/paceboy/customView/blob/master/app/viewuse.gif)


### Requirements

Android Studio
