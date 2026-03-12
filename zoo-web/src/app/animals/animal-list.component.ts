import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Animal } from './animal';
import { AnimalApiService } from './animal-api.service';

@Component({
  selector: 'app-animal-list',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './animal-list.component.html'
})
export class AnimalListComponent implements OnInit {
  private animalApi = inject(AnimalApiService);
  
  animals: Animal[] = [];
  isLoading = true;
  errorMessage = '';

  ngOnInit(): void {
        this.animalApi.getAllAnimals().subscribe({
            next: (data) => {
                console.log('animals from api', data);
                this.animals = data;
                this.isLoading = false;
            },
            error: (error) => {
                this.errorMessage = 'Failed to load animals. Please try again later.';
                console.error('Error fetching animals:', error);
                this.isLoading = false;
            }
        });
    }
}