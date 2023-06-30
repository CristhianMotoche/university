export class User {
  id?:string;
  nombre: string;
  createdAt?: Date;
  updatedAt?: Date;

  constructor(id?: string, nombre?: string, createdAt?: Date, updatedAt?:Date) {
    this.id = id
    this.nombre = nombre
    this.createdAt = createdAt
    this.updatedAt = updatedAt
  }
}
