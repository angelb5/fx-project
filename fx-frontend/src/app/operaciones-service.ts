import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { FxOperacion } from './model/fx-operacion';

@Injectable({
  providedIn: 'root',
})
export class OperacionesService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080';

  const get = () => {
    this.http.get<FxOperacion[]>(this.apiUrl + "/api/fx/operaciones")
  }
}
