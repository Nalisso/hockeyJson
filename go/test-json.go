package main
import ( "fmt"; "encoding/json" )
type Test1 struct { A string; B int }
type Test2 struct { T []Test1; A []string; B []int }

func main() {
  var t = Test2{
    T: []Test1{ Test1{A:"nisse", B:42}, Test1{A:"kalle", B:22}, },
    A: []string{"hello","world"},
    B: []int{42,22},
  }

  fmt.Println("t as var: ", t)

  j,_ := json.Marshal(t)
  fmt.Println("t as JSON:", string(j))

  // change some stuff
  t.T[1].A = "olle"
  t.A[1] = "åhus"
  t.B[1] = 99 
  j,_ = json.Marshal(t)
  fmt.Println("t as JSON:", string(j))
}
