#include <iostream>
#include <queue>
using namespace std;

int N;
queue<int> q;
int main(void){
  scanf("%d", &N);

  for(int i=1; i<=N; i++){
    q.push(i);
  }

  while(q.size() != 1){
    cout << q.front() << " ";
    q.pop();
    q.push(q.front());
    q.pop();
  }

  cout << q.front();

  return 0;
}