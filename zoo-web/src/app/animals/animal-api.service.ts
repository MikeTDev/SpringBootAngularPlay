import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from './animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalApiService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/animals';

  getAllAnimals(): Observable<Animal[]> {
    return this.http.get<Animal[]>(this.apiUrl);
  }

  getAnimalByName(name: string): Observable<Animal> {
    return this.http.get<Animal>(`${this.apiUrl}/${name}`);
  }

  addAnimal(animal: Animal): Observable<Animal> {
    return this.http.post<Animal>(this.apiUrl, animal);
  }
}