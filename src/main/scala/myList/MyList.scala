package myList

import scala.annotation.tailrec
import scala.util.Random

sealed trait MyList[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends MyList[Nothing] // A `List` data constructor representing the empty list
/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `Nil` or another `Cons`.
 */
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList { // `List` companion object. Contains functions for creating and working with lists.
  def sum(ints: MyList[Int]): Int = ints match {
    case Nil => 0
    case Cons(lstHead, lstTail) => lstHead + sum(lstTail)
  }

  def product(ds: MyList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(lstHead, lstTail) => lstHead * product(lstTail)
  }

  def apply[A](as: A*): MyList[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def append[A](a1: MyList[A], a2: MyList[A]): MyList[A] = a1 match {
    case Nil => a2
    case Cons(lstHead, lstTail) => Cons(lstHead, append(lstTail, a2))
  }

  // Bonus should throw exception
  def tail[A](l: MyList[A]): MyList[A] = l match {
    case Nil => sys.error("Empty list")
    case Cons(_, lstTail) => lstTail
  }

  def head[A](l: MyList[A]): A = l match {
    case Nil => sys.error("Empty list")
    case Cons(lstHead, _) => lstHead
  }

  def setHead[A](l: MyList[A], h: A): MyList[A] = l match {
    case Nil => sys.error("Empty list")
    case Cons(_, lstTail) => Cons(h, lstTail)
  }

  @tailrec
  def drop[A](l: MyList[A], n: Int): MyList[A] =
    if (n == 0) l
    else l match {
      case Nil => Nil
      case Cons(_, lstTail) => drop(lstTail, n - 1)
    }

  @tailrec
  def dropWhile[A](l: MyList[A], f: A => Boolean): MyList[A] = l match {
    case Cons(lstHead, lstTail) if f(lstHead) => dropWhile(lstTail, f)
    case _ => l
  }

  def foldRight[A,B](as: MyList[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def filter[A](l: MyList[A], f: A => Boolean): MyList[A] =
    foldRight(l , Nil: MyList[A])((el: A, acc: MyList[A]) =>
      if (f(el)) Cons(el, acc)
      else acc
    )

  def init[A](l: MyList[A]): MyList[A] = l match {
    case Nil => sys.error("Empty list!")
    case Cons(_, Nil) => Nil
    case Cons(lstHead, lstTail) => Cons(lstHead, init(lstTail))
  }

  def length[A](l: MyList[A]): Int = foldRight(l, 0)((_, acc) => acc + 1)

  @tailrec
  def foldLeft[A, B](as: MyList[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  def reverse[A](l: MyList[A]): MyList[A] =
    foldLeft(l, MyList[A]())((acc, el) => Cons(el, acc))

  @tailrec
  def get[A](n: Int, ls: MyList[A]): A  = (n, ls) match {
    case (0, Cons(h, _)) => h
    case (n, Cons(_, tail)) => get(n-1, tail)
    case (_, Nil) => sys.error("Empty list!")
  }

  def getRandom[A](l: MyList[A]): A = length(l) match {
    case 0 => sys.error("Empty list!")
    case s => get(Random.nextInt(s), l)
  }

  def main(args: Array[String]): Unit = {
    val xs = MyList(1, 2, 3, 4)
    val ex1 = get(1, xs)
    val ex2 = getRandom(xs)
    println(xs)
    println(ex1)
    println(ex2)

  }

}
