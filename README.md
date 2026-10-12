# Radio Hora Android — proyecto fuente

Reproductor local Android inspirado en la automatización de radio: playlist, controles, reproducción en segundo plano y locución de hora cada 15 minutos **después de finalizar la canción en curso**.

## Compilar APK
1. Instala Android Studio y JDK 17.
2. Abre la carpeta `RadioHoraAndroid` con **Open**.
3. Espera a que Gradle descargue dependencias. Requiere internet.
4. En Android Studio selecciona **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
5. El archivo se crea en `app/build/outputs/apk/debug/app-debug.apk`.
6. Instala el APK en Android 8 o superior, permitiendo instalar desde esa fuente.

## Uso
Abre la aplicación, pulsa AGREGAR MÚSICA, selecciona varios audios locales y pulsa REPRODUCIR. El reproductor continúa con pantalla apagada mediante MediaSessionService y muestra controles del sistema. La app anuncia la hora en el siguiente cambio de canción después de las 00, 15, 30 y 45 min, siempre que la voz TTS en español esté instalada.

## Límites de esta versión inicial
- La voz **masculina no está garantizada**: depende de voces instaladas en Android; si ninguna contiene `male` en su nombre, se usa la voz española predeterminada.
- La lista se mantiene solo durante la sesión de la pantalla; no hay persistencia tras reiniciar la aplicación.
- Si el dispositivo se apaga, Android detiene el servicio o la canción no termina, no se puede garantizar un anuncio puntual. El modo esperar anuncia al pasar a la siguiente canción, no exactamente a la hora programada.
- No incluye todavía crossfade, editor de eventos, streaming ni automatización completa tipo ZaraRadio.
- Código entregado sin ejecutar compilación ni pruebas en un teléfono real.
