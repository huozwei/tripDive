package com.dive.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dive.entity.Users;
import com.dive.service.UsersService;

/**
 * @desc   duo
 * @author HZW
 * @date   2017年6月16日 下午12:06:07
 */
public class AddDataTask {
	Logger logger = Logger.getLogger(AddDataTask.class);
	@Autowired
	private UsersService usersService;
	
	//执行添加多线程
	public void addData(){
		long startTime = System.currentTimeMillis();
		try {
			List<Users> listuser = new ArrayList<Users>();
			for (int i = 0; i < 3; i++) {
				Users user = new Users();
				if(i==2){
					user.setUserName("kddddddd");
				}else{
					user.setUserName("tests"+i);
				}
				user.setPassword("passwords"+i);
				listuser.add(user);
			}
			/*Boolean b = usersService.addUsers(listuser);*/
			/*List<Users> userList = usersService.GetUserList();
			dealListWithForkJoin(userList,startTime);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


/**
 * forkjoin处理任务集合
 * @param list
 * @param start
 */
public void dealListWithForkJoin(List<Users> list,long start){
	ForkJoinTaskUtil task = new ForkJoinTaskUtil(list, 0,list.size());
	//拿到开启的线程数
	ForkJoinPool pool = new ForkJoinPool(5);
	pool.execute(task);
	do {
		/*logger.info("线程数量:"+ pool.getPoolSize());
		logger.info("当前执行任务的线程的数量: "+ pool.getActiveThreadCount());
		logger.info("线程窃取数:"+pool.getStealCount());
		logger.info("线程并行数:"+pool.getParallelism());*/
	} while (!task.isDone());
	pool.shutdown();
	if (task.isCompletedNormally()) {
		logger.info("任务都完成了,时间："+(System.currentTimeMillis() - start) / 1000 + "秒");
	}
}

private class ForkJoinTaskUtil extends RecursiveAction{
		private static final long serialVersionUID = 1L;

		private List<Users> list;

		private int first;

		private int last;

		public ForkJoinTaskUtil(List<Users> list, int first, int last) {
			this.list = list;
			this.first = first;
			this.last = last;
		}

		@Override
		protected void compute() {
			if (last - first < 10){
				subTaskHandle();
			}else {
				int middle = (last + first) / 2;
				//System.out.println("开启的线程数："+getQueuedTaskCount());
				ForkJoinTaskUtil t1 = new ForkJoinTaskUtil(list,
						first, middle + 1);
				ForkJoinTaskUtil t2 = new ForkJoinTaskUtil(list,
						middle + 1, last);
				invokeAll(t1, t2);
			}
		}
		private void subTaskHandle() {
			for (int i = first; i < last; i++) {
				logger.info("数值为："+list.get(i).getUserName());
				//usersService.insertUsers(list.get(i));
			}
			
		}
	}

}	