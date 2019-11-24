# Android_Serializable_Parcelable_Learning
About Android Serializable Parcelable Learning

### 为什么需要序列化
当我们需要在多个 Activity 之间传递对象时，我们不能直接传递对象的引用，我们应该对对象进行序列化，将对象转换成可传输的状态，然后放到 Intent 中进行传递。在 Android 中，我们可以通过 Serializable 和 Parcelable 来对对象进行序列化。

### Serializable
  Serailizable 是 Java 的一个接口，很容易实现，Java 在一定的条件下会自动帮我们去序列化对象，但是处理的方法相对较慢，会产生很多的临时变量，频繁的触发垃圾回收机制。

### Parcelable 
  Parcelable 是 Android 特有的一个接口，它有丰富的方法在 Activitys 之间传递数据，当我们需要通过 Intent 在 Activitys 之间传递一个对象时，使用 Parcelabel 会比 Serializable 快很多，但实现该接口会相对于复杂一些，需要重写它的 describeContent() 和 writeToParcel(Parcel dest, int flags) 方法。

### 具体实现方法
  通过 Serializable 方法，对 User 对象进行序列化，然后传递给 SecondActivity，以及通过 Parcelable 方法对 Article 对象进行序列化，然后传递给 ThirdActivity，效果如下：

![Android 序列化Demo](https://github.com/JereChen11/Android_Serializable_Parcelable_Learning/raw/master/readmeImage/serial.gif)
