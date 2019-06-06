# 多线程学习

## Thread

````
new Thread().start();

````

## AsyncTask<参数， 进度， 返回值>

````

回调函数
doInBackGround：执行要完成的任务， 耗时操作在这里完成
onPreExcute：执行线程前做的操作，例如初始化等等
onPostExcute：当doInbackGround操作完成后，系统自动调用此方法并传入返回值
onProgressUpdate：doInBackGround方法执行的过程中，调用publishprogress（int）方法更新进度

.使用AsyncTask的注意事项

① 必须在UI线程中创建AsyncTask的实例.

② 只能在UI线程中调用AsyncTask的execute方法.

③ AsyncTask被重写的四个方法是系统自动调用的,不应手动调用.

④ 每个AsyncTask只能被执行(execute方法)一次,多次执行将会引发异常.

⑤ AsyncTask的四个方法,只有doInBackground方法是运行在其他线程中,其他三个方法都运行在UI线程中,也就说其他三个方法都可以进行UI的更新操作.

````