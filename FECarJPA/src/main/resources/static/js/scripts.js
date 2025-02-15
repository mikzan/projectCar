/**
 * Tolgo e rimetto l'active se clicco su uno degli elementi della navbar
 */
        document.addEventListener("DOMContentLoaded", function() {
			
			const preloader = document.querySelector('.preloader');
			 if (preloader) {
			   // Durata totale della dissolvenza (2.5 secondi)
			   const duration = 1500;
			   const interval = 50; // Intervallo in millisecondi
			   const step = interval / duration; // Step di riduzione opacità

			   let opacity = 1;

			   const fadeEffect = setInterval(function () {
			     if (opacity > 0) {
			       opacity -= step; // Riduce l'opacità gradualmente
			       preloader.style.opacity = opacity;
			     } else {
			       clearInterval(fadeEffect); // Ferma il timer
			       preloader.style.display = "none"; // Nasconde completamente l'elemento
			     }
			   }, interval);
			 }
	
			
            const navItems = document.querySelectorAll('.nav-item .nav-link');
            const currentUrl = window.location.pathname; // Otteniamo l'URL della pagina corrente

            // Funzione per gestire l'attivazione della scheda corretta in base all'URL
            function setActiveNav() {
                navItems.forEach(item => {
                    // Rimuovi la classe 'active' da tutte le schede
                    item.classList.remove('active');
                    
                    // Aggiungi la classe 'active' all'elemento che corrisponde all'URL corrente
                    if (currentUrl.includes(item.getAttribute('href'))) {
                        item.classList.add('active');
                    }
                });
            }

            // Chiamata alla funzione per impostare correttamente la scheda attiva
            setActiveNav();

            // Aggiungi il listener di clic per ogni elemento della navbar
            navItems.forEach(item => {
                item.addEventListener('click', function(e) {
                    // Rimuovi la classe 'active' da tutti gli altri elementi
                    navItems.forEach(i => i.classList.remove('active'));
                    // Aggiungi la classe 'active' all'elemento cliccato
                    e.target.classList.add('active');
                });
            });
        });
