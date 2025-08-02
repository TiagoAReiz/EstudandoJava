import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core'; // 👈 1. Importar inject
import { PLATFORM_ID } from '@angular/core'; // 👈 2. Importar PLATFORM_ID
import { isPlatformBrowser } from '@angular/common'; // 👈 3. Importar isPlatformBrowser

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  // 4. "Injetar" as dependências necessárias
  const platformId = inject(PLATFORM_ID);
  
  let token: string | null = null;

  // 5. Verificar se está no navegador ANTES de usar o localStorage
  if (isPlatformBrowser(platformId)) {
    token = localStorage.getItem('authToken');
  }

  if (token) {
    const clonedRequest = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`),
    });
    return next(clonedRequest);
  }

  return next(req);
};