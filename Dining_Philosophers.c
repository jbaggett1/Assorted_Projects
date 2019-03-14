/*Here is the dininig philosopher's problem. It is described in great detail in the book.
 Each philosopher will die if they try to pick up a fork that isn't there (mutual exclusion), and will die if they don't eat before too long
 -- 20 seconds (bounded wait, progress).
 Your job is to keep the philosophers alive using concurrency primitives: locks, mutexes, semaphores in the pthread library.
 You can put them in the thread function (Philosopher), or you can put them in the fork pickup function.
 
 Each philosopher (0-4) will try to take her fork and the fork above her (philosopher 3 uses forks 3 and 4, philosopher 4 uses forks 4 and 0, etc).
 */
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>
int forks[5] = {1,1,1,1,1};
pthread_mutex_t lock;
/*Global array to keep track of which forks are available -- 1 means available, 0 means not. Philosopher i will eat with fork i, and i+1 (addition done modulo 5, so philosopher 4 will use 4 and 0.*/

int pickup_forks(int philosopher_number, time_t *last_meal)
/*Function to pick up the forks -- it takes the philosopher number that is picking up the forks, and the variable that represents the last time the philosopher ate, so it can reset it. Philosophers are very grumpy people, so if they want to eat and there are no forks they will just starve themselves to death and return 1, which means their thread will die.*/
{
    

    printf("Philosopher %d has started her meal!\n",philosopher_number);
    
    if (forks[(philosopher_number)%2] == 1)
        
        {
            if(forks[(philosopher_number+1)%5] < 1)
        {
        printf("Philosopher %d wanted to eat but there was no fork to her right. She is furious and starved herself in protest\n",philosopher_number);
        return 1;
        }
    
        else
        {
            forks[(philosopher_number+1)%5]--;
       
        }
            sleep(2);
    
            if(forks[philosopher_number] < 1)
            {
                printf("Philosopher %d wanted to eat but there was no fork to her left. She is furious and starved herself in protest\n",philosopher_number);
                return 1;
            }
            else
            {
                forks[philosopher_number]--;
        
            }
    
            time(last_meal);
        }
    
    else
    {
        if(forks[(philosopher_number+1)%5] < 1)
    {
            printf("Philosopher %d wanted to eat but there was no fork to her left. She is furious and starved herself in protest\n",philosopher_number);
            return 1;
    }
        
        else
        {
            forks[philosopher_number]--;
        
        }
        sleep(2);
        
        if(forks[philosopher_number] < 1)
        {
            printf("Philosopher %d wanted to eat but there was no fork to her right. She is furious and starved herself in protest\n",philosopher_number);
            return 1;
        }
        else
        {
            forks[(philosopher_number+1)%5]--;
            
        }
        
        time(last_meal);
        
    }
    /*If we just ate successfully, reset that philosopher's last_meal time*/
    return 0;
}
void return_forks(int philosopher_number)
{
    /*Function to return the forks*/
    printf("Philosopher %d has politely returned her forks. \n",philosopher_number);
    forks[(philosopher_number + 1)%5]++;
    forks[philosopher_number]++;
    pthread_mutex_unlock(&lock);
}
void *Philosopher(void *num)
{
    /*Our thread function -- seed the random number generator, and while (true), wait for 0-5 seconds (thinking), pickup forks (if it returns true or 1, we exit), then wait again for 0-5 seconds (eating) and return them*/
    int philosopher_number = *((int *)num);
    
    /*Here we cast the argument as an integer and save it, as before*/
    
    time_t last_meal,current_time;
    time(&last_meal);
    
    /*Create variables to keep track of time, and set the last_meal time to the start of the program*/
    
    srand(time(NULL)+philosopher_number);
    
    /*Seed the random number generator*/
    while(1)
    {
        time(&current_time);
        if(current_time - last_meal > 20 )
        {
            printf("Philosopher %d didn't eat for 20 seconds, so she died\n",philosopher_number);
            return num;
        }
        /*If the time elapsed since the last meal of this philosopher is more than 20 seconds, she dies*/
        
        sleep(rand()%5);
        /*This represents thinking*/
         pthread_mutex_lock(&lock);
        if(pickup_forks(philosopher_number,&last_meal))
            continue;
        /*If that function returned 1, then the philosopher couldn't pick up a fork.*/
        
        sleep(rand()%5);
        return_forks(philosopher_number);
        
    }
    
    
}
int main()
{
    pthread_t philosophers[5];
    if (pthread_mutex_init(&lock, NULL) != 0)
    {
        printf("\n mutex lock init has failed\n");
        return 1;
    }
    int i=0;
    int args[5];
    for(i=0;i<5;i++)
    {
        args[i] = i;
        pthread_create(&philosophers[i],NULL,Philosopher,(void*)&args[i]);
    }
    
    for(i=0;i<5;i++)
    {
        pthread_join(philosophers[i],NULL);
    }
    pthread_mutex_destroy(&lock);
    return 0;
}
