package com.knoldus.exceptions


trait MachinexException extends Exception

case class InconsistentTrainingDataException(label: String) extends MachinexException

case class InconsistentDataException(label: String) extends MachinexException

